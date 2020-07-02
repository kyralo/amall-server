package online.kyralo.amall.common.exceptions.business;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.BusinessException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/7/1
 * \* Time: 23:35
 * \* Description: 商家异常
 * \
 */

@Slf4j
public class MerchantException extends BusinessException {
    public MerchantException(String message) {
        super(message);
    }

    public MerchantException(ResCode resCode) {
        super(resCode);
    }

    public MerchantException(long code, String message) {
        super(code, message);
    }
}