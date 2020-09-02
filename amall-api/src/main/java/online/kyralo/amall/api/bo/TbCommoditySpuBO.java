package online.kyralo.amall.api.bo;

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
public class TbCommoditySpuBO extends Base {

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
     * 商家ID
     */
    private String merchantId;

    /**
     * spu名称
     */
    private String name;

    /**
     * spu描述
     */
    private String spuDesc;

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