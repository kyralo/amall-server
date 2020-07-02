package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * 销售属性值
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbCommodityAttrValueVO", description = "销售属性值模型")
public class TbCommodityAttrValueVO {

    /**
     * 销售属性值ID
     */
    @ApiModelProperty("销售属性值ID")
    private String id;

    /**
     * 销售属性ID
     */
    @ApiModelProperty("销售属性ID")
    private String attrId;

    /**
     * 销售属性值
     */
    @ApiModelProperty("销售属性值")
    private String value;

    /**
     * 销售属性值描述
     */
    @ApiModelProperty("销售属性值描述")
    private String attrValueDesc;

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