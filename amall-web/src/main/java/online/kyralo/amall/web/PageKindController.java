package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.CommodityService;
import online.kyralo.amall.api.KindService;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.web.vo.PKindVO;
import online.kyralo.amall.web.vo.TbCommodityVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/25
 * \* Time: 20:29
 * \* Description: 商品类型
 * \
 */

@RestController
@RequestMapping("/api/v1/kinds")
@Api(tags = "商品类型")
@Validated
public class PageKindController {

    @Resource
    private KindService kindService;
    @Resource
    private CommodityService commodityService;

    @GetMapping
    @ApiOperation(value = " 查询商品类型 列表 商品类型页 ", response = PKindVO.class)
    public Res<?> getPcKindPageInfo(@ApiParam("一级类型") @RequestParam(required = false, defaultValue = "ALL") String primaryType,
                                    @ApiParam("二级类型") @RequestParam(required = false, defaultValue = "ALL") String secondType) {

        PKindVO kinds = new PKindVO();

        Object kindsVO = kindService.listKinds().getData();
        List<PKindVO.CommodityKind> commodityKinds =
                CopyUtil.copyList(kindsVO, PKindVO.CommodityKind.class);
        kinds.setCategories(commodityKinds);

        Object commoditiesBO = commodityService.listByCategory(primaryType, secondType).getData();
        List<TbCommodityVO> commodities = CopyUtil.copyList(commoditiesBO, TbCommodityVO.class);
        kinds.setCommodities(commodities);

        return ResUtil.success(kinds);
    }
}
