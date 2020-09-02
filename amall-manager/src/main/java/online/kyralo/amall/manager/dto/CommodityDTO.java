package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;

/**
 * 商品spu表
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommodityDTO extends Base {

    /**
     * SPU ID
     */
    private String id;

    /**
     * 品牌ID
     */
    private String brandId;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * spu名称
     */
    private String name;

    /**
     * spu描述
     */
    private String desc;

    /**
     * 卖点
     */
    private String sellingPoint;

    /**
     * spu单位
     */
    private String unit;

    /**
     * banner图片 多个图片逗号分隔
     */
    private String bannerUrl;

    /**
     * 商品介绍主图 多个图片逗号分隔
     */
    private String mainUrl;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Integer status;

    /**
     * SKU创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * SKU更新时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}