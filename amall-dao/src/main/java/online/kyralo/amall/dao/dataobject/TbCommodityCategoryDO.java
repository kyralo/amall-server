package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 商品类型
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_commodity_category")
public class TbCommodityCategoryDO {

    /**
     * 商品类型ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父级商品类型ID 默认为 -1 表示当前商品类型无父类型
     */
    @Column(name = "parent_category_id")
    private Integer parentCategoryId;

    /**
     * 商品类型 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 商品类型 类型说明
     */
    @Column(name = "info")
    private String info;

    /**
     * 商品类型 图标
     */
    @Column(name = "icon_url")
    private String iconUrl;

    /**
     * 商品类型 大图
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 0表示一级类型, 1表示其他类型(二级类型), 默认为0
     */
    @Column(name = "is_primary")
    private boolean primary;

    /**
     * 状态 1:ENABLE, 0:DISABLE, -1:DELETED
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