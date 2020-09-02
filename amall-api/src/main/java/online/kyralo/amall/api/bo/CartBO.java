package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 0:52
 * \* Description: 购物车
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartBO extends Base {
    /**
     * 商品ID
     */
    private String commodityId;

    /**
     * 商品缩略图
     */
    private String commodityImgUrl;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品品牌
     */
    private String commodityBrandName;


    /**
     * 商品参数 列表
     */
    private List<ParameterBO<String>> commodityParameters;

    /**
     * 商品单价
     */
    private Double price;

    /**
     * 商品数量
     */
    private Integer count;
}
