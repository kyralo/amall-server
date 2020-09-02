package online.kyralo.amall.common.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.annotation.MyDemo;
import online.kyralo.amall.common.utils.AnnotateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/2
 * \* Time: 15:13
 * \* Description: DEMO
 * \
 */

@Component
@Slf4j
@Aspect
public class MyDemoAspect {
    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.xxx.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(online.kyralo.amall.common.annotation.MyDemo)")
    public void point() {
    }


    @Before("point()")
    public void doBefore(JoinPoint point) {
        // 开始打印请求日志

        // 打印请求相关参数
        log.info("========================================== Start ==========================================");

        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSON(AnnotateUtil.getParameterMap(point)));

        // 获取注解描述
        log.info("Annotation Description, {}", JSON.toJSON(AnnotateUtil.getAonnotateParameterMap(point, MyDemo.class)));

    }

    @Around("point()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = point.proceed();
        // 打印出参
        log.info("Response Args  : {}", JSON.toJSON(result));
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }


    @After("point()")
    public void doAfter(JoinPoint point) {
        // 接口结束后换行，方便分割查看
        log.info("=========================================== End ===========================================");
    }

    @AfterReturning("point()")
    public void afterReturning(JoinPoint point) {

    }

    @AfterThrowing("point()")
    public void afterThrowing(JoinPoint point) {

    }
}
