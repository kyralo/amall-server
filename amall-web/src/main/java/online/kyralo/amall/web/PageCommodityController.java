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
    public Res<?> getPcHomePageInfo(@ApiParam("商品ID") @RequestParam("commodityId") String commoditySkuId) {

        PCommodityVO page = new PCommodityVO();

        // 商品信息
        Object commodityBO = commodityService.queryById(commoditySkuId).getData();
        PCommodityVO.Commodity commodity = new PCommodityVO.Commodity();
        CopyUtil.copyBean(commodityBO, commodity);
        page.setCommodity(commodity);

        // 商家推荐商品 列表
        Object merchantRecommondCommoditiesBO =
                commodityService.listMerchantRecommondCommodities(commoditySkuId).getData();
        List<TbCommodityVO> merchantRecommendCommodities =
                CopyUtil.copyList(merchantRecommondCommoditiesBO, TbCommodityVO.class);
        page.setRecommendCommodities(merchantRecommendCommodities);

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

        // 商品评论
        Object commodityCommentsBO = tbUserCommentService.listCommentsByCommodityId(commoditySkuId).getData();
        PCommodityVO.CommodityComments commodityComments = new PCommodityVO.CommodityComments();
        CopyUtil.copyBean(commodityCommentsBO, commodityComments);
        page.setCommodityComments(commodityComments);

        // 其他该类型商品 列表
        Object recommondCommoditiesBO =
                commodityService.listRecommondCommodities(commoditySkuId).getData();
        List<TbCommodityVO> recommendCommodities =
                CopyUtil.copyList(recommondCommoditiesBO, TbCommodityVO.class);
        page.setOtherCommodities(recommendCommodities);

        return ResUtil.success(page);
    }

}
