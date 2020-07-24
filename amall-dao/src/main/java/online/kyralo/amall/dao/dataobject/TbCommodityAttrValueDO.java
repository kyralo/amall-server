package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "tb_commodity_attr_value")
public class TbCommodityAttrValueDO {

    /**
     * 销售属性值ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 销售属性ID
     */
    @Column(name = "attr_id")
    private String attrId;

    /**
     * 销售属性值
     */
    @Column(name = "value")
    private String value;

    /**
     * 销售属性值描述
     */
    @Column(name = "attr_value_desc")
    private String attrValueDesc;

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