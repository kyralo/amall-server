package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "tb_commodity_spu")
public class TbCommoditySpuDO {

    /**
     * SPU ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    private String brandId;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * spu名称
     */
    @Column(name = "name")
    private String name;

    /**
     * spu描述
     */
    @Column(name = "spu_desc")
    private String spuDesc;

    /**
     * 卖点
     */
    @Column(name = "selling_point")
    private String sellingPoint;

    /**
     * spu单位
     */
    @Column(name = "unit")
    private String unit;

    /**
     * banner图片 多个图片逗号分隔
     */
    @Column(name = "banner_url")
    private String bannerUrl;

    /**
     * 商品介绍主图 多个图片逗号分隔
     */
    @Column(name = "main_url")
    private String mainUrl;

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