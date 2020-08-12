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
 * \* Description: PC 用户端 商家页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PMerchantVO", description = "商家页面模型")
public class PMerchantVO extends Base {

    /**
     * 商家信息
     */
    @ApiModelProperty("商家信息")
    private TbMerchantVO merchant;

    /**
     * 商品 类型列表
     */
    @ApiModelProperty("商品 类型列表")
    private List<PKindVO> kinds;
}
