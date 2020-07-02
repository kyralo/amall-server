package online.kyralo.amall.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * sku库存表
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TbCommoditySkuStockModel {

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * SKU ID
     */
    private String skuId;

    /**
     * SKU color
     */
    private String skuColor;

    /**
     * SKU 商品尺码名
     */
    private String skuSizeName;

    /**
     * 库存量
     */
    private Integer quantity;

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