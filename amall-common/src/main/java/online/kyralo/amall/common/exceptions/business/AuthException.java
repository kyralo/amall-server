package online.kyralo.amall.common.exceptions.business;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.BusinessException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/22
 * \* Time: 18:50
 * \* Description:
 * \
 */
@Slf4j
public class AuthException extends BusinessException {

    public AuthException(String message) {
        super(message);
    }

    public AuthException(ResCode resCode) {
        super(resCode);
    }

    public AuthException(long code, String message) {
        super(code, message);
    }
}
