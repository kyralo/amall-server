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
 * \* Description: PC 用户端 订单页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "POrderVO", description = "订单页面模型")
public class POrderVO extends Base {

    /**
     * 订单ID
     */
    @ApiModelProperty("订单ID")
    private String orderId;

    /**
     * 订单 地址列表
     */
    @ApiModelProperty("订单 地址列表")
    private List<TbUserAddressVO> addresses;

    /**
     * 订单 商品列表
     */
    @ApiModelProperty("订单 商品列表")
    private List<PCartVO> carts;
}
