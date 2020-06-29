package online.kyralo.amall.common.exceptions.common;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.CommonException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 11:14
 * \* Description: User
 * \
 */
@Slf4j
public class UserException extends CommonException {

    public UserException(String message) {
        super(message);
        log.error("用户模块异常: {}", message);
    }

    public UserException(ResCode resCode) {
        super(resCode);
        log.error("用户模块异常: {}", resCode.getMessage());
    }

    public UserException(long code, String message) {
        super(code, message);
        log.error("用户模块异常: {}", message);
    }
}
