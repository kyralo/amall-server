package online.kyralo.amall.common.constants;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 14:09
 * \* Description: 响应码
 * \
 */
public class ResCodeConstant {

    public static final long SUCCESS = 10200;
    public static final long FAILED = 10500;
    public static final long VALIDATE_FAILED = 10400;
    public static final long UNAUTHORIZED = 10401;
    public static final long FORBIDDEN = 10403;
    public static final long NOT_FOUND = 10404;

    public static final long INVALID_REQUEST = 40001;
    public static final long INVALID_CLIENT = 40002;
    public static final long INVALID_GRANT = 40003;
    public static final long INVALID_SCOPE = 40004;
    public static final long INVALID_TOKEN = 40005;
    public static final long INSUFFICIENT_SCOPE = 40010;
    public static final long REDIRECT_URI_MISMATCH = 40020;
    public static final long ACCESS_DENIED = 40030;
    public static final long METHOD_NOT_ALLOWED = 40040;
    public static final long SERVER_ERROR = 40050;
    public static final long UNAUTHORIZED_CLIENT = 40060;
}
