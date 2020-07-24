package online.kyralo.amall.common.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * \* Created with Intellij IDEA.
 * \* @author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 10:14
 * \* Description: http响应封装
 * \
 */

@Setter
@Getter
@ToString
public class Res<T> {

    private long code;
    private String message;
    private T data;

    public Res(ResCode resCode, T data) {
        this.data = data;
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public Res(ResCode resCode) {
        this.data = null;
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public Res(long code, String message) {
        this.data = null;
        this.code = code;
        this.message = message;
    }

    public Res(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
