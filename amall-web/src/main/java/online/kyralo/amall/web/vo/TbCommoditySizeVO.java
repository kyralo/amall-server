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
@ApiModel(value = "TbCommoditySizeVO", description = "sku表模型")
public class TbCommoditySizeVO {

    /**
     * 商品尺码自增ID
     */
    @ApiModelProperty("商品尺码自增ID")
    private Integer id;

    /**
     * SKU ID
     */
    @ApiModelProperty("SKU ID")
    private String skuId;

    /**
     * 商品尺码名
     */
    @ApiModelProperty("商品尺码名")
    private String sizeName;

    /**
     * sku描述(商家对产品的描述) json存储 e.g: [{"name":"腰围", "value":"62-72"},{"name":"裤长", "value":"92"}]
     */
    @ApiModelProperty("sku描述(商家对产品的描述) json存储 e.g: [{ name : 腰围 ,  value : 62-72 },{ name : 裤长 ,  value : 92 }]")
    private String sizeDesc;

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