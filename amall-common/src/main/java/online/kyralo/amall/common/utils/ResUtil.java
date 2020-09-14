package online.kyralo.amall.common.utils;


import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import org.springframework.stereotype.Component;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 10:40
 * \* Description: Rest响应结果工具类
 * \
 */

@Component
public class ResUtil {

    public static Res<?> success() {
        return new Res<>(ResCode.SUCCESS);
    }

    public static <T> Res<T> success(T data) {
        return new Res<>(ResCode.SUCCESS, data);
    }

    public static <T> Res<T> success(long code, String msg) {
        return new Res<>(code, msg);
    }

    public static Res<?> error() {
        return new Res<>(ResCode.FAILED);
    }

    public static <T> Res<T> error(T data) {
        return new Res<>(ResCode.FAILED, data);
    }

    public static <T> Res<T> error(long code, String msg) {
        return new Res<>(code, msg);
    }

    public static <T> Res<T> response(ResCode resCode, T data) {
        return new Res<>(resCode, data);
    }

    public static <T> Res<T> response(long resCode, String msg, T data) {
        return new Res<>(resCode, msg, data);
    }
}
