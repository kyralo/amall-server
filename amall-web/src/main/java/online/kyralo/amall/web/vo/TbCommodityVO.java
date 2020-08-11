package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/6
 * \* Time: 23:32
 * \* Description: 商品
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbCommodityVO", description = "商品表模型")
public class TbCommodityVO extends Base {

    /**
     * SKU ID
     */
    @ApiModelProperty("SKU ID")
    private String id;

    /**
     * 商家ID
     */
    @ApiModelProperty("商家ID")
    private String merchantId;

    /**
     * sku描述(商家对产品的描述)
     */
    @ApiModelProperty("sku描述(商家对产品的描述)")
    private String skuDesc;

    /**
     * 商品介绍主图
     */
    @ApiModelProperty("商品介绍主图")
    private String mainPicUrl;

    /**
     * 折扣
     */
    @ApiModelProperty("折扣")
    private Integer discount;

    /**
     * 商品售价
     */
    @ApiModelProperty("商品售价")
    private Double price;

    /**
     * 商品月销售
     */
    @ApiModelProperty("商品月销售")
    private Integer monthlySales;

}
