package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "tb_order")
public class TbOrderDO {

    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号 日期加id
     */
    @Column(name = "num")
    private String num;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * SKU id
     */
    @Column(name = "sku_id")
    private String skuId;

    /**
     * SKU color
     */
    @Column(name = "sku_color")
    private String skuColor;

    /**
     * SKU 商品尺码名
     */
    @Column(name = "sku_size_name")
    private String skuSizeName;

    /**
     * 付款，整数方式保存
     */
    @Column(name = "pay_fee")
    private Integer payFee;

    /**
     * 付款，金额对应的小数位数
     */
    @Column(name = "pay_scale")
    private Integer payScale;

    /**
     * 支付类型,1-在线支付
     */
    @Column(name = "payment_type")
    private Integer paymentType;

    /**
     * 运费,单位是元
     */
    @Column(name = "postage")
    private Integer postage;

    /**
     * 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 支付时间
     */
    @Column(name = "payment_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @Column(name = "send_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    /**
     * 交易完成时间
     */
    @Column(name = "end_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 交易关闭时间
     */
    @Column(name = "close_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date closeTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}