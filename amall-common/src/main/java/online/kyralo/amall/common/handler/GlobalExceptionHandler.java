package online.kyralo.amall.common.handler;

import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.constants.ResCodeConstant;
import online.kyralo.amall.common.exceptions.business.*;
import online.kyralo.amall.common.utils.ResUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


/**
 * @author wangchen
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Res<?> handlerException(Exception ex) {
        log.error("未知异常: {} \n", ex.getCause().toString());
        return ResUtil.error();
    }

    /**
     * 参数校验
     *
     * @param request http请求
     * @param ex      异常
     * @return 响应结果
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Res<?> handler(HttpServletRequest request, ConstraintViolationException ex) {
        StringBuilder msg = new StringBuilder();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            msg.append(violation.getMessage());
        }
        return ResUtil.error(ResCodeConstant.VALIDATE_FAILED, msg.toString());
    }

    /**
     * 权限
     * 权限模块异常
     *
     * @param ex 异常
     * @return 响应结果
     */
    @ExceptionHandler(AuthException.class)
    public Res<String> handlerAuthException(AuthException ex) {
        log.info("权限模块异常: {} \n", ex.getCause().toString());
        return ResUtil.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 用户
     * 用户模块异常
     *
     * @param ex 异常
     * @return 响应结果
     */
    @ExceptionHandler(UserException.class)
    public Res<String> handlerUserException(UserException ex) {
        log.info("用户模块异常: {} \n", ex.getCause().toString());
        return ResUtil.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 管理员
     * 管理员模块异常
     *
     * @param ex 异常
     * @return 响应结果
     */
    @ExceptionHandler(AdminException.class)
    public Res<String> handlerAdminException(AdminException ex) {
        log.info("管理员模块异常: {} \n", ex.getCause().toString());
        return ResUtil.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 订单
     * 订单模块异常
     *
     * @param ex 异常
     * @return 响应结果
     */
    @ExceptionHandler(OrderException.class)
    public Res<String> handlerOrderException(OrderException ex) {
        log.info("订单模块异常: {} \n", ex.getCause().toString());
        return ResUtil.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 商品
     * 商品模块异常
     *
     * @param ex 异常
     * @return 响应结果
     */
    @ExceptionHandler(CommodityException.class)
    public Res<String> handlerCommodityException(CommodityException ex) {
        log.info("商品模块异常: {} \n", ex.getCause().toString());
        return ResUtil.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 商家
     * 商家模块异常
     *
     * @param ex 异常
     * @return 响应结果
     */
    @ExceptionHandler(MerchantException.class)
    public Res<String> handlerMerchantException(MerchantException ex) {
        log.info("商家模块异常: {} \n", ex.getCause().toString());
        return ResUtil.error(ex.getCode(), ex.getMessage());
    }
}
