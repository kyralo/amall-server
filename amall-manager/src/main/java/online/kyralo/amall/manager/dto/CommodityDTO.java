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
    private Integer primaryCategoryName;

    /**
     * 商品 子级 分类ID
     */
    private Integer childCategoryId;

    /**
     * 商品 子级 分类名
     */
    private Integer childCategoryName;

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
    private List<ParameterDTO<SalesValueDTO>> sales;

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