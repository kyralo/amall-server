package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;

/**
 * 订单
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbOrderVO", description = "订单模型")
public class TbOrderVO extends Base {

    /**
     * 订单id
     */
    @ApiModelProperty("订单id")
    private Integer id;

    /**
     * 订单号 日期加id
     */
    @ApiModelProperty("订单号 日期加id")
    private String num;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * SKU id
     */
    @ApiModelProperty("SKU id")
    private String skuId;

    /**
     * SKU color
     */
    @ApiModelProperty("SKU color")
    private String skuColor;

    /**
     * SKU 商品尺码名
     */
    @ApiModelProperty("SKU 商品尺码名")
    private String skuSizeName;

    /**
     * 付款，整数方式保存
     */
    @ApiModelProperty("付款，整数方式保存")
    private Integer payFee;

    /**
     * 付款，金额对应的小数位数
     */
    @ApiModelProperty("付款，金额对应的小数位数")
    private Integer payScale;

    /**
     * 支付类型,1-在线支付
     */
    @ApiModelProperty("支付类型,1-在线支付")
    private Integer paymentType;

    /**
     * 运费,单位是元
     */
    @ApiModelProperty("运费,单位是元")
    private Integer postage;

    /**
     * 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    @ApiModelProperty("订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭")
    private Integer status;

    /**
     * 支付时间
     */
    @ApiModelProperty("支付时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @ApiModelProperty("发货时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    /**
     * 交易完成时间
     */
    @ApiModelProperty("交易完成时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 交易关闭时间
     */
    @ApiModelProperty("交易关闭时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date closeTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}