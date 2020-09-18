package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.CommodityService;
import online.kyralo.amall.api.TbMerchantService;
import online.kyralo.amall.api.TbUserCommentService;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.web.vo.PCommodityVO;
import online.kyralo.amall.web.vo.TbCommodityCategoryVO;
import online.kyralo.amall.web.vo.TbCommodityVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/22
 * \* Time: 17:09
 * \* Description: 商品
 * \
 */

@RestController
@RequestMapping("/api/v1/commodity")
@Api(tags = "PC端页面 商品页")
@Validated
public class PageCommodityController {

    @Resource
    private CommodityService commodityService;
    @Resource
    private TbMerchantService tbMerchantService;
    @Resource
    private TbUserCommentService tbUserCommentService;

    @GetMapping("/pc/user")
    @ApiOperation(value = "查询商品页信息", response = PCommodityVO.class)
    public Res<?> getPcHomePageInfo(@ApiParam("商品ID") @RequestParam("commodityId") String commoditySkuId,
                                    @ApiParam("商品一级类型") @RequestParam("primaryType") String primaryType,
                                    @ApiParam("商品颜色") @RequestParam("currentColor") String currentColor,
                                    @ApiParam("商品尺寸") @RequestParam("currentSize") String currentSize,
                                    @ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer merchantPageNum,
                                    @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer merchantPageSize,
                                    @ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer recPageNum,
                                    @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "20", required = false) Integer recPageSize) throws InterruptedException {

        PCommodityVO page = new PCommodityVO();

        // 商品信息
        Object commodityBO = commodityService.queryById(commoditySkuId, currentColor, currentSize).getData();
        PCommodityVO.Commodity commodity = new PCommodityVO.Commodity();
        CopyUtil.copyBean(commodityBO, commodity);
        page.setCommodity(commodity);

        // 商家信息
        Object merchantBO = tbMerchantService.getMerchantByCommoditySkuId(commoditySkuId).getData();
        PCommodityVO.Merchant merchant = new PCommodityVO.Merchant();
        CopyUtil.copyBean(merchantBO, merchant);
        page.setMerchant(merchant);

        // 商家商品类型
        Object merchantCategoriesBO =
                tbMerchantService.getMerchantCommodityKindByCommoditySkuId(commoditySkuId).getData();
        List<TbCommodityCategoryVO> merchantCategories =
                CopyUtil.copyList(merchantCategoriesBO, TbCommodityCategoryVO.class);
        page.setMerchantCategories(merchantCategories);

        // 商家推荐商品 列表
        Object merchantRecommondCommoditiesBO =
                commodityService.listMerchantRecommondCommodities(merchant.getId(), commoditySkuId, merchantPageNum, merchantPageSize).getData();
        List<TbCommodityVO> merchantRecommendCommodities =
                CopyUtil.copyList(merchantRecommondCommoditiesBO, TbCommodityVO.class);
        page.setRecommendCommodities(merchantRecommendCommodities);

        // 商品评论
        Object commodityCommentsBO = tbUserCommentService.listCommentsByCommodityId(commoditySkuId).getData();
        PCommodityVO.CommodityComments commodityComments = new PCommodityVO.CommodityComments();
        CopyUtil.copyBean(commodityCommentsBO, commodityComments);
        page.setCommodityComments(commodityComments);

        // 其他该类型商品 列表
        Object recommondCommoditiesBO =
                commodityService.listRecommondCommodities(commoditySkuId, recPageNum, recPageSize).getData();
        List<TbCommodityVO> recommendCommodities =
                CopyUtil.copyList(recommondCommoditiesBO, TbCommodityVO.class);
        page.setOtherCommodities(recommendCommodities);

        return ResUtil.success(page);
    }

}
