package online.kyralo.amall.common.constants;

public class SecurityConstant {
    // 1 hours
    public static final long EXPIRATION_TIME = 3600_000;
    public static final String TOKEN_PREFIX = "Bearer_";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";

    // role

    /**
     * 用户
     */
    public static final String DJSH_ROLE_USER = "user";
    /**
     * 管理员
     */
    public static final String DJSH_ROLE_ADMIN = "admin";
    /**
     * 超级管理员
     */
    public static final String DJSH_ROLE_ROOT = "root";

}
