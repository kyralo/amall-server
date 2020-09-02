package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/4
 * \* Time: 21:43
 * \* Description: PC 用户端 商家页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PMerchantVO", description = "商家页面模型")
public class PMerchantVO extends Base {

    /**
     * 商家信息
     */
    @ApiModelProperty("商家信息")
    private TbMerchantVO merchantInfo;


    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommodityKind {

        /**
         * 一级类型
         */
        @ApiModelProperty("商品 一级类型")
        private TbCommodityCategoryVO primaryCategory;

        /**
         * 二级类型 列表
         */
        @ApiModelProperty("商品 二级类型 列表")
        private List<TbCommodityCategoryVO> secondCategories;

    }

    /**
     * 商品 一级类型 列表
     */
    @ApiModelProperty("商品 一级类型 列表")
    private List<PMerchantVO.CommodityKind> categories;

    /**
     * 商品 列表
     */
    @ApiModelProperty("商品 列表")
    private List<TbCommodityVO> commodities;
}
