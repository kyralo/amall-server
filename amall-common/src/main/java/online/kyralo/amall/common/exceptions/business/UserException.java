package online.kyralo.amall.common.exceptions.business;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.BusinessException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 11:14
 * \* Description: User
 * \
 */
@Slf4j
public class UserException extends BusinessException {

    public UserException(String message) {
        super(message);
    }

    public UserException(ResCode resCode) {
        super(resCode);
    }

    public UserException(long code, String message) {
        super(code, message);
    }
}
