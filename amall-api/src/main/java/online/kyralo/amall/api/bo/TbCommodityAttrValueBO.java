package online.kyralo.amall.api.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

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
public class TbCommodityAttrValueBO extends Base {

    /**
     * 销售属性值ID
     */
    private String id;

    /**
     * 销售属性ID
     */
    private String attrId;

    /**
     * 销售属性值
     */
    private String value;

    /**
     * 销售属性值描述
     */
    private String attrValueDesc;

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