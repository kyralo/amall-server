package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.lang.reflect.Array;
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
     * 商品品牌ID
     */
    private String brandId;

    /**
     * 商品品牌名称
     */
    private String brandName;

    /**
     * 商品卖点
     */
    private String sellingPoint;

    /**
     * 商品分类ID
     */
    private Integer categoryId;

    /**
     * 商家商品服务说明
     */
    private List<String> serviceInfo;

    /**
     * 商品月销量
     */
    private Integer cumulativeSales;

    /**
     * 产品参数
     */
    private List<ParameterBO<String>> commodityParameters;

    /**
     * 穿着效果
     */
    private List<String> commodityInEffectImages;

    /**
     * 尺码说明
     */
    private List<ParameterBO<Array>> commoditySizeSpec;

    /**
     * 商品销售属性
     */
    private List<ParameterBO<SalesValueBO>> sales;

    /**
     * 商品套餐
     */
    private List<ComboBO> combos;
}
