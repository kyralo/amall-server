package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * sku表
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbCommoditySkuVO", description = "sku表模型")
public class TbCommoditySkuVO {

    /**
     * SKU ID
     */
    @ApiModelProperty("SKU ID")
    private String id;

    /**
     * SPU ID
     */
    @ApiModelProperty("SPU ID")
    private String spuId;

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
     * banner图片 多个图片逗号分隔
     */
    @ApiModelProperty("banner图片 多个图片逗号分隔")
    private String bannerUrl;

    /**
     * 商品介绍主图 多个图片逗号分隔
     */
    @ApiModelProperty("商品介绍主图 多个图片逗号分隔")
    private String mainUrl;

    /**
     * 商品参数 {attr_value_id} 多个销售属性值逗号分隔 固定加上 颜色, 尺码属性
     */
    @ApiModelProperty("商品参数 {attr_value_id} 多个销售属性值逗号分隔 固定加上 颜色, 尺码属性")
    private String commodityParameters;

    /**
     * 图文详情 图片url 多个图片逗号分隔
     */
    @ApiModelProperty("图文详情 图片url 多个图片逗号分隔")
    private String commodityGraphicDetails;

    /**
     * 穿着效果 图片url 多个图片逗号分隔
     */
    @ApiModelProperty("穿着效果 图片url 多个图片逗号分隔")
    private String commodityInEffect;

    /**
     * 尺码说明 {attr_value_id} (map保存尺码名) 多个销售属性值逗号分隔
     */
    @ApiModelProperty("尺码说明 {attr_value_id} (map保存尺码名) 多个销售属性值逗号分隔")
    private String commoditySizeSpecification;

    /**
     * 售价，整数方式保存
     */
    @ApiModelProperty("售价，整数方式保存")
    private Integer priceFee;

    /**
     * 售价，金额对应的小数位数
     */
    @ApiModelProperty("售价，金额对应的小数位数")
    private Integer priceScale;

    /**
     * 市场价，整数方式保存
     */
    @ApiModelProperty("市场价，整数方式保存")
    private Integer marketPriceFee;

    /**
     * 市场价，金额对应的小数位数
     */
    @ApiModelProperty("市场价，金额对应的小数位数")
    private Integer marketPriceScale;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}