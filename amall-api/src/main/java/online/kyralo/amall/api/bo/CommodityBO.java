package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 1:16
 * \* Description: 商品
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommodityBO extends Base {
    /**
     * 商品ID
     */
    private String id;

    /**
     * 商品预览图 列表
     */
    private List<String> preImgUrls;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品品牌名称
     */
    private String brandName;

    /**
     * 商品销售属性
     */
    private List<ParameterBO<SalesValueBO>> sales;

    /**
     * 商品套餐
     */
    private List<ComboBO> combos;
}
