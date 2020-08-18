package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.lang.reflect.Array;
import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/4
 * \* Time: 21:42
 * \* Description: PC 用户端 商品页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PCommodityVO", description = "商品页面模型")
public class PCommodityVO extends Base {

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Parameter<T> extends Base {
        /**
         * 商品参数名
         */
        @ApiModelProperty("商品参数名")
        private String name;
        /**
         * 商品参数值
         */
        @ApiModelProperty("商品参数值")
        private T value;
    }

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SalesValue extends Base {

        /**
         * 商品颜色名
         */
        @ApiModelProperty("颜色名")
        private String colorName;

        /**
         * 商品尺寸名
         */
        @ApiModelProperty("尺寸名")
        private String sizeName;

        /**
         * 商品价格
         */
        @ApiModelProperty("价格")
        private Double price;

        /**
         * 商品折扣
         */
        @ApiModelProperty("折扣")
        private Float discount;

        /**
         * 商品存货
         */
        @ApiModelProperty("存货")
        private Integer stock;

    }

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Combo extends Base {

        /**
         * 套餐名
         */
        @ApiModelProperty("套餐名")
        private String comboName;

        /**
         * 套餐说明
         */
        @ApiModelProperty("套餐说明")
        private String desc;

        /**
         * 套餐组合条件 颜色列表
         */
        @ApiModelProperty("套餐组合条件 颜色列表")
        private List<String> colorNames;

        /**
         * 套餐价格
         */
        @ApiModelProperty("价格")
        private Double price;

        /**
         * 套餐折扣
         */
        @ApiModelProperty("折扣")
        private Float discount;

        /**
         * 套餐存货
         */
        @ApiModelProperty("存货")
        private Integer stock;

    }

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
         * 商品预览图 列表
         */
        @ApiModelProperty("商品预览图 列表")
        private List<String> preImgUrls;

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
         * 商品销售属性
         */
        @ApiModelProperty("商品销售属性")
        private List<Parameter<SalesValue>> sales;

        /**
         * 商品套餐
         */
        @ApiModelProperty("商品套餐")
        private List<Combo> combos;

    }

    // 第一栏目

    /**
     * 商品信息
     */
    @ApiModelProperty("商品信息")
    private Commodity commodity;

    /**
     * 商品月销量
     */
    @ApiModelProperty("商品月销量")
    private Integer cumulativeSales;

    /**
     * 商家服务说明
     */
    @ApiModelProperty("商家服务说明")
    private List<String> serviceInfo;

    /**
     * 商家推荐商品 列表
     */
    @ApiModelProperty("推荐商品 列表")
    private List<TbCommodityVO> recommendCommodities;

    // 第二栏目

    /**
     * 商品描述
     */
    @ApiModelProperty("商品描述")
    private String commodityDesc;

    /**
     * 产品参数
     */
    @ApiModelProperty("产品参数")
    private List<Parameter<String>> commodityParameters;

    /**
     * 穿着效果
     */
    @ApiModelProperty("穿着效果")
    private List<String> commodityInEffectImages;

    /**
     * 尺码说明
     */
    @ApiModelProperty("尺码说明")
    private List<Parameter<Array>> commoditySizeSpec;

    public static class Merchant extends Base {

        /**
         * 商家id
         */
        @ApiModelProperty("商家id")
        private String id;

        /**
         * 商家昵称
         */
        @ApiModelProperty("商家id")
        private String name;

        /**
         * 商家店名
         */
        @ApiModelProperty("商家id")
        private String storeName;

        /**
         * 商家头像
         */
        @ApiModelProperty("商家头像")
        private String avatarUrl;

    }

    /**
     * 商家信息
     */
    @ApiModelProperty("商家信息")
    private Merchant merchant;

    /**
     * 商家商品类型
     */
    @ApiModelProperty("商家商品类型")
    private List<TbCommodityCategoryVO> merchantCategories;


    /**
     * 商品评分
     */
    @ApiModelProperty("商品评分")
    private Integer rate;

    /**
     * 一级 用户评论
     */
    @ApiModelProperty("一级 用户评论")
    private List<TbUserCommentVO> primaryComments;

    /**
     * 二级 用户评论
     */
    @ApiModelProperty("二级 用户评论")
    private List<TbUserCommentVO> secondComments;


    /**
     * 其他该类型商品 列表
     */
    @ApiModelProperty("其他该类型商品 列表")
    private List<TbCommodityVO> otherCommodities;

}
