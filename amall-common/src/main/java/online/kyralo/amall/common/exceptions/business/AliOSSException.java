package online.kyralo.amall.common.exceptions.business;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.BusinessException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/7/8
 * \* Time: 21:02
 * \* Description: 文件上传异常
 * \
 */

@Slf4j
public class AliOSSException extends BusinessException {

    public AliOSSException(String message) {
        super(message);
        log.error("文件上传模块异常: {}", message);
    }

    public AliOSSException(ResCode resCode) {
        super(resCode);
        log.error("文件上传模块异常: {}", resCode.getMessage());
    }

    public AliOSSException(long code, String message) {
        super(code, message);
        log.error("文件上传模块异常: {}", message);
    }

}