package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

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
public class TbCommoditySkuDTO extends Base {

    /**
     * SKU ID
     */
    private String id;

    /**
     * SPU ID
     */
    private String spuId;

    /**
     * 商家ID
     */
    private String merchantId;

    /**
     * sku描述(商家对产品的描述)
     */
    private String desc;

    /**
     * banner图片 多个图片逗号分隔
     */
    private String bannerUrl;

    /**
     * 商品介绍主图 多个图片逗号分隔
     */
    private String mainUrl;

    /**
     * 商品参数 {attr_value_id} 多个销售属性值逗号分隔 固定加上 颜色, 尺码属性
     */
    private String commodityParameters;

    /**
     * 图文详情 图片url 多个图片逗号分隔
     */
    private String commodityGraphicDetails;

    /**
     * 穿着效果 图片url 多个图片逗号分隔
     */
    private String commodityInEffect;

    /**
     * 尺码说明 {attr_value_id} (map保存尺码名) 多个销售属性值逗号分隔
     */
    private String commoditySizeSpecification;

    /**
     * 售价，整数方式保存
     */
    private Integer priceFee;

    /**
     * 售价，金额对应的小数位数
     */
    private Integer priceScale;

    /**
     * 市场价，整数方式保存
     */
    private Integer marketPriceFee;

    /**
     * 市场价，金额对应的小数位数
     */
    private Integer marketPriceScale;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}