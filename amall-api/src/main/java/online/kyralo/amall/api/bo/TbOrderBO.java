package online.kyralo.amall.api.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class TbOrderBO extends Base {

    /**
     * 订单id
     */
    private Integer id;

    /**
     * 订单号 日期加id
     */
    private String num;

    /**
     * 用户id
     */
    private String userId;

    /**
     * SKU id
     */
    private String skuId;

    /**
     * 付款，整数方式保存
     */
    private Integer payFee;

    /**
     * 付款，金额对应的小数位数
     */
    private Integer payScale;

    /**
     * 支付类型,1-在线支付
     */
    private Integer paymentType;

    /**
     * 运费,单位是元
     */
    private Integer postage;

    /**
     * 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    private Integer status;

    /**
     * 支付时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    /**
     * 交易完成时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 交易关闭时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date closeTime;

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