package online.kyralo.amall.common.api;

/**
 * 封装API的请求码
 *
 * @author wangchen
 */

public interface RestCode {
    /**
     * 响应码
     *
     * @return code
     */
    long getCode();

    /**
     * 响应消息
     *
     * @return message
     */
    String getMessage();
}
