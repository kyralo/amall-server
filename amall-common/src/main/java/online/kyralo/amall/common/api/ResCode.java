package online.kyralo.amall.common.api;


import online.kyralo.amall.common.constants.ResCodeConstant;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/6/19
 * \* Time: 9:22
 * \* Description: 业务响应码code
 * \
 */
public enum ResCode implements RestCode {

    // 基本响应码
    /**
     * 操作成功
     */
    SUCCESS(ResCodeConstant.SUCCESS, "操作成功"),
    /**
     * 操作失败
     */
    FAILED(ResCodeConstant.FAILED, "操作失败"),
    /**
     * 参数检验失败
     */
    VALIDATE_FAILED(ResCodeConstant.VALIDATE_FAILED, "请求参数检验失败"),
    /**
     * 没有相关权限
     */
    FORBIDDEN(ResCodeConstant.FORBIDDEN, "没有相关权限"),
    /**
     * 操作对象不存在
     */
    NOT_FOUND(ResCodeConstant.NOT_FOUND, "操作对象不存在"),

    // 权限
    INVALID_REQUEST(40001, "无效请求"),
    INVALID_CLIENT(40002, "无效client_id"),
    INVALID_GRANT(40003, "无效授权"),
    INVALID_SCOPE(40004, "无效scope"),
    INVALID_TOKEN(40005, "无效token"),
    INSUFFICIENT_SCOPE(40010, "授权不足"),
    REDIRECT_URI_MISMATCH(40020, "redirect url不匹配"),
    ACCESS_DENIED(40030, "拒绝访问"),
    METHOD_NOT_ALLOWED(40040, "不支持该方法"),
    SERVER_ERROR(40050, "权限服务错误"),
    UNAUTHORIZED_CLIENT(40060, "未授权客户端"),
    /**
     * 暂未登录或token已经过期
     */
    UNAUTHORIZED(ResCodeConstant.UNAUTHORIZED, "暂未登录或token已经过期"),
    UNSUPPORTED_RESPONSE_TYPE(40070, " 支持的响应类型"),
    UNSUPPORTED_GRANT_TYPE(40071, "不支持的授权类型");

    // 业务响应码
    // 用户模块

    // 管理员模块

    // 商品模块

    // 订单模块

    ;


    ResCode(long code, String message) {
    }

    @Override
    public long getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
