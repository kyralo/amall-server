package online.kyralo.amall.common.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/2
 * \* Time: 18:12
 * \* Description: Aop注解工具类
 * \
 */

@Component
public class AnnotateUtil {

    /**
     * 获取参数Map集合
     *
     * @param joinPoint 切点
     * @return 参数Map集合
     */
    public static <T extends JoinPoint> Map<String, Object> getParameterMap(T joinPoint) {
        Map<String, Object> param = new HashMap<>(1);
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        return param;
    }

    /**
     * 获取当前注释的方法的注解参数
     *
     * @param joinPoint 切点
     * @param pClass 注解类型
     * @param <T> 切点泛型
     * @param <P> 注解泛型
     * @return 当前注释的方法的注解参数
     */
    public static <T extends JoinPoint, P extends Annotation> P getAnnotateParameterMap(T joinPoint, Class<P> pClass) {
        //此处joinPoint的实现类是MethodInvocationProceedingJoinPoint
        Signature signature = joinPoint.getSignature();
        //获取参数名
        MethodSignature methodSignature = (MethodSignature) signature;
        return methodSignature.getMethod().getAnnotation(pClass);
    }
}
