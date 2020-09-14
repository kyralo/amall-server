package online.kyralo.amall.manager.dto;

import lombok.*;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 1:07
 * \* Description:
 * \
 */
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    /**
     * 购物车 用户 ID
     */
    private  String userId;

    /**
     * 购物车 商品 SKU ID
     */
    private String commodityId;

    /**
     * 购物车 商品库存 ID
     */
    private Integer commodityStockId;

    /**
     * 购物车 商品购物车数量
     */
    private Integer addCount;
}
