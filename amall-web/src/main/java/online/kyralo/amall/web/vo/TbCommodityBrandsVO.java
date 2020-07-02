package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * 品牌表
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbCommodityBrandsVO", description = "品牌表模型")
public class TbCommodityBrandsVO {

    /**
     * 品牌ID
     */
    @ApiModelProperty("品牌ID")
    private String id;

    /**
     * 品牌名称
     */
    @ApiModelProperty("品牌名称")
    private String name;

    /**
     * 品牌描述
     */
    @ApiModelProperty("品牌描述")
    private String brandsDesc;

    /**
     * 品牌logo图片
     */
    @ApiModelProperty("品牌logo图片")
    private String logoUrl;

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