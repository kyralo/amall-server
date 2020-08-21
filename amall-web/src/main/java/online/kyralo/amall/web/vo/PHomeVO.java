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
 * \* Time: 21:42
 * \* Description: PC 用户端 主页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PHomeVO", description = "主页页面模型")
public class PHomeVO extends Base {

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommodityKind extends Base {
        /**
         * 一级类型
         */
        @ApiModelProperty("一级类型")
        private TbCommodityCategoryVO primaryCategory;
        /**
         * 二级类型 列表
         */
        @ApiModelProperty("二级类型 列表")
        private List<TbCommodityCategoryVO> secondCategories;
    }

    // 第一栏目

    /**
     * 类型 列表
     */
    @ApiModelProperty("类型 列表")
    private List<CommodityKind> kinds;

    /**
     * 活动 列表
     */
    @ApiModelProperty("活动 列表")
    private List<PActivityVO> activities;

    /**
     * 用户信息
     */
    @ApiModelProperty("用户信息")
    private TbUserVO user;

    /**
     * 购物车 数量
     */
    @ApiModelProperty("购物车 数量")
    private Integer cartCount;

    /**
     * 收藏夹 数量
     */
    @ApiModelProperty("收藏夹 数量")
    private Integer collectionCount;

    /**
     * 待付订单 数量
     */
    @ApiModelProperty("待付订单 数量")
    private Integer orderCount;

    // 第二栏目

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Seckill extends Base {

        /**
         * 正在执行的 整点场 秒杀
         */
        @ApiModelProperty("正在执行的 整点场 秒杀")
        private String seckillClock;

        /**
         * 秒杀的商品 前五名
         */
        @ApiModelProperty("秒杀的商品 前五名")
        private List<TbCommodityVO> seckillCommodities;
    }

    /**
     * 秒杀
     */
    @ApiModelProperty("秒杀")
    private Seckill seckill;

    // 第三栏目

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShowModule extends Base {

        /**
         * 展示图
         */
        @ApiModelProperty("展示图")
        private String picUrl;

        /**
         * 类型
         */
        @ApiModelProperty("类型")
        private CommodityKind showModuleKind;

        /**
         * 商品 列表
         */
        @ApiModelProperty("商品 列表")
        private List<TbCommodityVO> commodities;

        /**
         * 热销商品 列表
         */
        @ApiModelProperty("热销商品 列表")
        private List<TbCommodityVO> hotCommodities;

    }

    /**
     * 商品首页展示模块 列表
     */
    @ApiModelProperty("商品首页展示模块 列表")
    private List<ShowModule> showModules;

    /**
     * 推荐商品 列表
     */
    @ApiModelProperty("推荐商品 列表")
    private List<TbCommodityVO> recommendCommodities;

}
