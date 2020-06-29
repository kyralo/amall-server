package online.kyralo.amall.common.exceptions.common;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.CommonException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/22
 * \* Time: 18:50
 * \* Description:
 * \
 */
@Slf4j
public class AuthException extends CommonException {

    public AuthException(String message) {
        super(message);
        log.error("权限模块异常: {}", message);
    }

    public AuthException(ResCode resCode) {
        super(resCode);
        log.error("权限模块异常: {}", resCode.getMessage());
    }

    public AuthException(long code, String message) {
        super(code, message);
        log.error("权限模块异常: {}", message);
    }
}
