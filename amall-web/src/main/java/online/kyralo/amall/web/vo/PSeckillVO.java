package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/4
 * \* Time: 21:44
 * \* Description: PC 用户端 秒杀页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PSeckillVO", description = "秒杀页面模型")
public class PSeckillVO extends Base {

    /**
     * 正在执行的 整点场 秒杀
     */
    @ApiModelProperty("正在执行的 整点场 秒杀")
    private String seckillClock;

    /**
     * 秒杀 广告
     */
    @ApiModelProperty("秒杀 广告")
    private PActivityVO ad;

    /**
     * 秒杀 一级类型 列表
     */
    @ApiModelProperty("商品 一级类型 列表")
    private List<TbCommodityCategoryVO> categories;

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Commodity extends Base {

        /**
         * 商品ID
         */
        @ApiModelProperty("商品ID")
        private String id;

        /**
         * 商品预览图 取列表第一项
         */
        @ApiModelProperty("商品预览图")
        private String preImgUrl;

        /**
         * 商品名称
         */
        @ApiModelProperty("商品名称")
        private String name;

        /**
         * 商品品牌名称
         */
        @ApiModelProperty("商品品牌名称")
        private String brandName;

        /**
         * 商品原价
         */
        @ApiModelProperty("商品原价")
        private Double price;

        /**
         * 商品折扣
         */
        @ApiModelProperty("折扣")
        private Float discount;

        /**
         * 商品当前存货
         */
        @ApiModelProperty("存货")
        private Integer stock;

        /**
         * 商品秒杀前存货
         */
        @ApiModelProperty("商品秒杀前存货")
        private Integer preStock;

    }

    /**
     * 秒杀 列表
     */
    @ApiModelProperty("商品 列表")
    private List<Commodity> commodities;
}
