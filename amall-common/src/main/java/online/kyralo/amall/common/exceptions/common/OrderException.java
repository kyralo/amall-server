package online.kyralo.amall.common.exceptions.common;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.CommonException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 11:14
 * \* Description: Order
 * \
 */
@Slf4j
public class OrderException extends CommonException {

    public OrderException(String message) {
        super(message);
        log.error("订单模块异常: {}", message);
    }

    public OrderException(ResCode resCode) {
        super(resCode);
        log.error("订单模块异常: {}", resCode.getMessage());
    }

    public OrderException(long code, String message) {
        super(code, message);
        log.error("订单模块异常: {}", message);
    }
}
