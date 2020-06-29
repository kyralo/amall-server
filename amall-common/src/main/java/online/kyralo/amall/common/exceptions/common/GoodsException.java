package online.kyralo.amall.common.exceptions.common;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.CommonException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 14:24
 * \* Description: goods
 * \
 */
@Slf4j
public class GoodsException extends CommonException {
    public GoodsException(String message) {
        super(message);
        log.error("商品模块异常: {}", message);
    }

    public GoodsException(ResCode resCode) {
        super(resCode);
        log.error("商品模块异常: {}", resCode.getMessage());
    }

    public GoodsException(long code, String message) {
        super(code, message);
        log.error("商品模块异常: {}", message);
    }
}
