package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class TbCommoditySizeDTO {

    /**
     * 商品尺码自增ID
     */
    private Integer id;

    /**
     * SKU ID
     */
    private String skuId;

    /**
     * 商品尺码名
     */
    private String sizeName;

    /**
     * sku描述(商家对产品的描述) json存储 e.g: [{"name":"腰围", "value":"62-72"},{"name":"裤长", "value":"92"}]
     */
    private String sizeDesc;

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