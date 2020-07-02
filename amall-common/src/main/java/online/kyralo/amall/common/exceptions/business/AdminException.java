package online.kyralo.amall.common.exceptions.business;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.BusinessException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 11:14
 * \* Description: Admin
 * \
 */
@Slf4j
public class AdminException extends BusinessException {

    public AdminException(String message) {
        super(message);
        log.error("管理员模块异常: {}", message);
    }

    public AdminException(ResCode resCode) {
        super(resCode);
        log.error("管理员模块异常: {}", resCode.getMessage());
    }

    public AdminException(long code, String message) {
        super(code, message);
        log.error("管理员模块异常: {}", message);
    }

}
