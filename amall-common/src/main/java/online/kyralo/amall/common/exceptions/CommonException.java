package online.kyralo.amall.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.constants.ResCodeConstant;

/**
 * @author wangchen
 */
@Slf4j
public class CommonException extends RuntimeException {
    private long code;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public CommonException(String message) {
        super(message);
        this.code = ResCodeConstant.FAILED;
    }

    public CommonException(ResCode resCode) {
        super(resCode.getMessage());
        this.code = resCode.getCode();
    }

    public CommonException(long code, String message) {
        super(message);
        this.code = code;
    }
}
