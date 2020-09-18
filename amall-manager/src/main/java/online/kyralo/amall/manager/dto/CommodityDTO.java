package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;
import java.util.List;

/**
 * 商品spu表
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommodityDTO extends Base {

    /**
     * 商品ID [SKU ID]
     */
    private String id;

    /**
     * 商品预览图 列表
     */
    private List<String> preImgUrls;

    /**
     * 商品介绍主图 多个图片逗号分隔
     */
    private List<String> mainUrls;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品品牌 ID
     */
    private String brandId;

    /**
     * 商品品牌名称
     */
    private String brandName;

    /**
     * 商品品牌 LOGO
     */
    private String brandLogo;

    /**
     * 商品卖点
     */
    private String sellingPoint;

    /**
     * spu单位
     */
    private String unit;

    /**
     * 商品 父级 分类ID
     */
    private Integer primaryCategoryId;

    /**
     * 商品 父级 分类名
     */
    private String primaryCategoryName;

    /**
     * 商品 子级 分类ID
     */
    private Integer childCategoryId;

    /**
     * 商品 子级 分类名
     */
    private String childCategoryName;

    /**
     * 当前选择商品 颜色
     */
    private String currentColor;

    /**
     * 当前选择商品 尺寸
     */
    private String currentSize;

    /**
     * 当前选择商品 价格
     */
    private Double currentPrice;

    /**
     * 当前选择商品 库存
     */
    private Integer currentStock;

    /**
     * 当前选择商品 折扣
     */
    private Float currentDiscount;

    /**
     * 商品月销量
     */
    private Integer cumulativeSales;

    /**
     * 商家商品服务说明
     */
    private List<String> serviceInfo;

    /**
     * 产品参数
     */
    private List<ParameterDTO<String>> commodityParameters;

    /**
     * 穿着效果
     */
    private List<String> commodityInEffectImages;

    /**
     * 尺码说明
     */
    private List<ParameterDTO<List<ParameterDTO<String>>>> commoditySizeSpec;

    /**
     * 商品销售属性
     */
    private List<ParameterDTO<List<SalesValueDTO>>> sales;

    /**
     * 商品套餐
     */
    private List<ComboDTO> combos;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Integer status;

    /**
     * SKU创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * SKU更新时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}