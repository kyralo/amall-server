package online.kyralo.amall.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

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
public class TbCommodityCategoryModel {

    /**
     * 商品类型ID
     */
    private Integer id;

    /**
     * 父级商品类型ID 默认为 -1 表示当前商品类型无父类型
     */
    private Integer parentCategoryId;

    /**
     * 商品类型 名称
     */
    private String name;

    /**
     * 商品类型 类型说明
     */
    private String info;

    /**
     * 商品类型 图标
     */
    private String iconUrl;

    /**
     * 商品类型 大图
     */
    private String picUrl;

    /**
     * 0表示一级类型, 1表示其他类型(二级类型), 默认为0
     */
    private boolean primary;

    /**
     * 状态 1:ENABLE, 0:DISABLE, -1:DELETED
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