package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 1:30
 * \* Description:
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommoditySeckillBO extends Base {

    /**
     * 商品ID
     */
    private String id;

    /**
     * 商品预览图 取列表第一项
     */
    private String preImgUrl;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品品牌名称
     */
    private String brandName;

    /**
     * 商品原价
     */
    private Double price;

    /**
     * 商品折扣
     */
    private Float discount;

    /**
     * 商品当前存货
     */
    private Integer stock;

    /**
     * 商品秒杀前存货
     */
    private Integer preStock;

}
