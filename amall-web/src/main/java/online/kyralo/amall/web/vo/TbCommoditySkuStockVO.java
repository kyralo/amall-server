package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "TbCommoditySkuStockVO", description = "sku库存表模型")
public class TbCommoditySkuStockVO {

    /**
     * 自增ID
     */
    @ApiModelProperty("自增ID")
    private Integer id;

    /**
     * SKU ID
     */
    @ApiModelProperty("SKU ID")
    private String skuId;

    /**
     * SKU color
     */
    @ApiModelProperty("SKU color")
    private String skuColor;

    /**
     * SKU 商品尺码名
     */
    @ApiModelProperty("SKU 商品尺码名")
    private String skuSizeName;

    /**
     * 库存量
     */
    @ApiModelProperty("库存量")
    private Integer quantity;

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