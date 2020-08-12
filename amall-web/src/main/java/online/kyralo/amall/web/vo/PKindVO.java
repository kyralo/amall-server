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
 * \* Time: 21:43
 * \* Description: PC 用户端 产品分类页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PKindVO", description = "商品分类页面模型")
public class PKindVO extends Base {

    /**
     * 商品 一级类型 列表
     */
    @ApiModelProperty("商品 一级类型 列表")
    private List<TbCommodityCategoryVO> categories;

    /**
     * 商品 列表
     */
    @ApiModelProperty("商品 列表")
    private List<TbCommodityVO> commodities;
}
