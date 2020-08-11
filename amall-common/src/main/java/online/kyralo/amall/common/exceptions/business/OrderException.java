package online.kyralo.amall.common.exceptions.business;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.BusinessException;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 11:14
 * \* Description: Order
 * \
 */
@Slf4j
public class OrderException extends BusinessException {

    public OrderException(String message) {
        super(message);
    }

    public OrderException(ResCode resCode) {
        super(resCode);
    }

    public OrderException(long code, String message) {
        super(code, message);
    }
}
