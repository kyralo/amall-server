package online.kyralo.amall.dao.dataobject;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品spu表
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_commodity_spu")
public class TbCommoditySpu {
    /**
     * SPU ID
     */
    @Id
    @Column(name = "id")
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
    @Column(name = "`name`")
    private String name;

    /**
     * spu描述
     */
    @Column(name = "`desc`")
    private String desc;

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
    @Column(name = "`status`")
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}