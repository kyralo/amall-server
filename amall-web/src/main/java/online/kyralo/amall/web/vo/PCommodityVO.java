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
         * 商品尺寸详细信息
         */
        @ApiModelProperty("商品尺寸详细信息")
        private TbCommoditySizeVO sizeInfo;

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
         * 商品库存ID
         */
        @ApiModelProperty("商品库存ID")
        private Integer commodityStockId;

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
         * 套餐ID
         */
        @ApiModelProperty("套餐ID")
        private String comboId;

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
         * 商品介绍主图 多个图片逗号分隔
         */
        @ApiModelProperty("商品介绍主图 多个图片逗号分隔")
        private List<String> mainUrls;

        /**
         * 商品名称
         */
        @ApiModelProperty("商品名称")
        private String name;

        /**
         * 商品品牌ID
         */
        @ApiModelProperty("商品品牌ID")
        private String brandId;

        /**
         * 商品品牌 LOGO
         */
        @ApiModelProperty("商品品牌LOGO")
        private String brandLogo;

        /**
         * 商品品牌名称
         */
        @ApiModelProperty("商品品牌名称")
        private String brandName;

        /**
         * 商品spu单位
         */
        @ApiModelProperty("商品spu单位")
        private String unit;

        /**
         * 商品卖点
         */
        @ApiModelProperty("商品卖点")
        private String sellingPoint;

        /**
         * 商品 父级 分类ID
         */
        @ApiModelProperty("商品 父级 分类ID")
        private Integer primaryCategoryId;

        /**
         * 商品 父级 分类名
         */
        @ApiModelProperty("商品 父级 分类名")
        private String primaryCategoryName;

        /**
         * 商品 子级 分类ID
         */
        @ApiModelProperty("商品 子级 分类ID")
        private Integer childCategoryId;

        /**
         * 商品 子级 分类名
         */
        @ApiModelProperty("商品 子级 分类名")
        private String childCategoryName;

        /**
         * 当前选择商品 颜色
         */
        @ApiModelProperty("当前选择商品 颜色")
        private String currentColor;

        /**
         * 当前选择商品 尺寸
         */
        @ApiModelProperty("当前选择商品 尺寸")
        private String currentSize;

        /**
         * 当前选择商品 价格
         */
        @ApiModelProperty("当前选择商品 价格")
        private Double currentPrice;

        /**
         * 当前选择商品 库存
         */
        @ApiModelProperty("当前选择商品 库存")
        private Integer currentStock;

        /**
         * 当前选择商品 折扣
         */
        @ApiModelProperty("当前选择商品 折扣")
        private Float currentDiscount;

        /**
         * 商品月销量
         */
        @ApiModelProperty("商品月销量")
        private Integer cumulativeSales;

        /**
         * 商家商品服务说明
         */
        @ApiModelProperty("商家商品服务说明")
        private List<String> serviceInfo;

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
        private List<Parameter<List<Parameter<String>>>> commoditySizeSpec;

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
     * 商家推荐商品 列表
     */
    @ApiModelProperty("推荐商品 列表")
    private List<TbCommodityVO> recommendCommodities;

    // 第二栏目

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Merchant extends Base {

        /**
         * 商家id
         */
        @ApiModelProperty("商家id")
        private String id;

        /**
         * 商家昵称
         */
        @ApiModelProperty("商家名")
        private String name;

        /**
         * 商家店名
         */
        @ApiModelProperty("商家店名")
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

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommodityComments extends Base {

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
    }

    /**
     * 商品评论
     */
    private CommodityComments commodityComments;

    /**
     * 其他该类型商品 列表
     */
    @ApiModelProperty("其他该类型商品 列表")
    private List<TbCommodityVO> otherCommodities;

}
