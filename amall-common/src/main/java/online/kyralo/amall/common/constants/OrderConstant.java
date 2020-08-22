package online.kyralo.amall.common.constants;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 17:53
 * \* Description: 订单相关常量
 * \
 */
public class OrderConstant {

    // 订单状态:0-已取消,10-未付款,20-已付款,40-已发货,50-交易成功,60-交易关闭

    /**
     * 0  已取消
     */
    public static final Integer OREDER_CANCELLED = 0;
    /**
     * 10 未付款
     */
    public static final Integer OREDER_NOT_PAID = 10;
    /**
     * 20 已付款
     */
    public static final Integer OREDER_PAID = 20;
    /**
     * 40 已发货
     */
    public static final Integer OREDER_DELIVERED = 40;
    /**
     * 50 交易成功
     */
    public static final Integer OREDER_TRADE_SUCCESS = 50;
    /**
     * 60 交易关闭
     */
    public static final Integer OREDER_TRADE_CLOSED = 60;
}
