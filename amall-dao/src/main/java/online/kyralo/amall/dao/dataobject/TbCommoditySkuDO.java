package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "tb_commodity_sku")
public class TbCommoditySkuDO {

    /**
     * SKU ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * SPU ID
     */
    @Column(name = "spu_id")
    private String spuId;

    /**
     * 商家ID
     */
    @Column(name = "merchant_id")
    private String merchantId;

    /**
     * sku描述(商家对产品的描述)
     */
    @Column(name = "sku_desc")
    private String skuDesc;

    /**
     * banner图片 多个图片逗号分隔
     */
    @Column(name = "banner_url")
    private String bannerUrl;

    /**
     * 商品介绍主图 多个图片逗号分隔
     */
    @Column(name = "main_url")
    private String mainUrl;

    /**
     * 商品参数 {attr_value_id} 多个销售属性值逗号分隔 固定加上 颜色, 尺码属性
     */
    @Column(name = "commodity_parameters")
    private String commodityParameters;

    /**
     * 图文详情 图片url 多个图片逗号分隔
     */
    @Column(name = "commodity_graphic_details")
    private String commodityGraphicDetails;

    /**
     * 穿着效果 图片url 多个图片逗号分隔
     */
    @Column(name = "commodity_in_effect")
    private String commodityInEffect;

    /**
     * 尺码说明 {attr_value_id} (map保存尺码名) 多个销售属性值逗号分隔
     */
    @Column(name = "commodity_size_specification")
    private String commoditySizeSpecification;

    /**
     * 售价，整数方式保存
     */
    @Column(name = "price_fee")
    private Integer priceFee;

    /**
     * 售价，金额对应的小数位数
     */
    @Column(name = "price_scale")
    private Integer priceScale;

    /**
     * 市场价，整数方式保存
     */
    @Column(name = "market_price_fee")
    private Integer marketPriceFee;

    /**
     * 市场价，金额对应的小数位数
     */
    @Column(name = "market_price_scale")
    private Integer marketPriceScale;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}