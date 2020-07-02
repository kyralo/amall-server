package online.kyralo.amall.common.exceptions.business;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.BusinessException;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 14:24
 * \* Description: goods
 * \
 */
@Slf4j
public class CommodityException extends BusinessException {
    public CommodityException(String message) {
        super(message);
    }

    public CommodityException(ResCode resCode) {
        super(resCode);
    }

    public CommodityException(long code, String message) {
        super(code, message);
    }
}
