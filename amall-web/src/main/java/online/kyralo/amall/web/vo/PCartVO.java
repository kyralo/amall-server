package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.io.Serializable;
import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/4
 * \* Time: 21:41
 * \* Description: PC 用户端 购物车页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PCartVO", description = "购物车页面模型")
public class PCartVO extends Base {

    /**
     * 商品ID
     */
    @ApiModelProperty("商品ID")
    private String commodityId;

    /**
     * 商品缩略图
     */
    @ApiModelProperty("商品缩略图")
    private String commodityImgUrl;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名")
    private String commodityName;

    /**
     * 商品品牌
     */
    @ApiModelProperty("商品品牌")
    private String commodityBrandName;


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

    /**
     * 商品参数 列表
     */
    @ApiModelProperty("商品参数 列表")
    private List<Parameter<String>> commodityParameters;

    /**
     * 商品单价
     */
    @ApiModelProperty("商品单价")
    private Double price;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private Integer count;
}
