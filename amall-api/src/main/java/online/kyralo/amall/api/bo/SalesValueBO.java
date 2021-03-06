package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 1:25
 * \* Description: 商品参数值
 * \
 */
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalesValueBO extends Base {

    /**
     * 商品颜色名
     */
    private String colorName;

    /**
     * 商品尺寸名
     */
    private String sizeName;

    /**
     * 商品尺寸详细信息
     */
    private TbCommoditySizeBO sizeInfo;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 商品折扣
     */
    private Float discount;

    /**
     * 商品库存ID
     */
    private Integer commodityStockId;

    /**
     * 商品存货
     */
    private Integer stock;

}
