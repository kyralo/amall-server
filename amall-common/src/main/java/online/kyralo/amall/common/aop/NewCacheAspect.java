package online.kyralo.amall.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.common.annotation.NewCache;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.constants.CacheEnum;
import online.kyralo.amall.common.constants.ResCodeConstant;
import online.kyralo.amall.common.utils.AnnotateUtil;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.RedisUtil;
import online.kyralo.amall.common.utils.ResUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/3
 * \* Time: 19:49
 * \* Description: 缓存
 * \
 */

@Component
@Slf4j
@Aspect
public class NewCacheAspect {

    private static final String POINT = ".";

    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.xxx.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(online.kyralo.amall.common.annotation.NewCache)")
    public void point() {
    }

    @Before("point()")
    public void doBefore(JoinPoint point) {
//        // 开始打印请求日志
//
//        // 打印请求相关参数
//        log.info("========================================== Start ==========================================");
//
//        // 打印调用 注解方法 的全路径以及执行方法
//        log.info("Class Method   : {}.{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
//
//        // 打印请求入参
//        log.info("Request Args   : {}", JSON.toJSON(AnnotateUtil.getParameterMap(point)));
//
//        // 获取注解描述
//        log.info("Annotation Description   : {}", JSON.toJSON(AnnotateUtil.getAnnotateParameterMap(point, NewCache.class)));

    }

    @Around("point()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {

        // 获取当前注解参数
        NewCache cacheMap = AnnotateUtil.getAnnotateParameterMap(point, NewCache.class);
        String cacheName = cacheMap.value();
        String annotateKey = cacheMap.key();
        CacheEnum cacheType = cacheMap.type();
        long timeout = cacheMap.timeout();
        TimeUnit timeunit = cacheMap.timeunit();

        // 获取当前方法参数map
        Map<String, Object> paramsMap = AnnotateUtil.getParameterMap(point);

        // 获取cacheKey
        String cacheKey = getCacheKey(annotateKey, paramsMap);

        // 处理
        Object result;
        switch (cacheType) {
            case QUERY : result = cacheAbleHandler(point, cacheName, cacheKey, timeout, timeunit); break;
            case UPDATE: result = cachePutHandler(point, cacheName, cacheKey, annotateKey, paramsMap, timeout, timeunit); break;
            case DELETE: result = cacheEvictHandler(point, cacheName, cacheKey); break;
            default: throw new Exception("注解类型出错!");
        }

        return result;
    }

    /**
     * 缓存查询
     * @param point 切点
     * @param cacheName 缓存名
     * @param cacheKey 缓存键
     * @param timeout 缓存时间 (默认为7天)
     * @param timeunit 缓存时间单位 (默认为天)
     * @return result
     */
    private Object cacheAbleHandler(ProceedingJoinPoint point,
                                    String cacheName,
                                    String cacheKey,
                                    long timeout,
                                    TimeUnit timeunit) throws Throwable {

        Object o = RedisUtil.getHash(cacheName, cacheKey);
        if (o != null){
            return ResUtil.success(o);
        }

        Object result = point.proceed();

        Object data = ((Res<?>)result).getData();
        if (data != null){
            RedisUtil.putExpireHash(cacheName, cacheKey, data, timeout, timeunit);
        }

        return result;
    }

    /**
     * 缓存更新
     * @param point 切点
     * @param cacheName 缓存名
     * @param cacheKey 缓存键
     * @param annotateKey 注解声明的 key
     * @param paramsMap 注解方法参数 map
     * @param timeout 缓存时间 (默认为7天)
     * @param timeunit 缓存时间单位 (默认为天)
     * @return result
     */
    private Object cachePutHandler(ProceedingJoinPoint point,
                                   String cacheName,
                                   String cacheKey,
                                   String annotateKey,
                                   Map<String, Object> paramsMap,
                                   long timeout,
                                   TimeUnit timeunit) throws Throwable {

        Object result = point.proceed();
        Res<?> res = (Res<?>)result;

        if (ResCodeConstant.SUCCESS != res.getCode()) {
            return result;
        }

        Object updateObject = getCachePutObject(annotateKey, paramsMap);
        if (updateObject == null) {
            return result;
        }

        Object data = RedisUtil.getHash(cacheName, cacheKey);
        if (data == null) {
            return result;
        }

        CopyUtil.copyBean(updateObject, data);
        RedisUtil.putExpireHash(cacheName, cacheKey, data, timeout, timeunit);

        return result;
    }

    /**
     * 缓存失效
     * @param point 切点
     * @param cacheName 缓存名
     * @param cacheKey 缓存键
     * @return result
     */
    private Object cacheEvictHandler(ProceedingJoinPoint point,
                                     String cacheName,
                                     String cacheKey) throws Throwable {

        Object result = point.proceed();
        Res<?> res = (Res<?>)result;

        if (ResCodeConstant.SUCCESS != res.getCode()) {
            return result;
        }

        RedisUtil.removeHash(cacheName, cacheKey);
        return result;
    }

    /**
     * 获取 cachePutObject
     * @param annotateKey 注解声明的 key ([更新方式]要求注解使用 object.[ properties/id ] 方式)
     * @param paramsMap 注解方法参数 map
     * @return cacheKey
     */
    public Object getCachePutObject( String annotateKey, Map<String, Object> paramsMap ){
        if ( annotateKey == null || "".equals(annotateKey) ){
            return null;
        }

        if (!annotateKey.contains(POINT)) {
            return null;
        }

        String[] keys = annotateKey.split("/.");

        return paramsMap.get(keys[0]);
    }

    /**
     * 获取 cacheKey
     * @param annotateKey 注解声明的 key
     * @param paramsMap 注解方法参数 map
     * @return cacheKey
     */
    public String getCacheKey( String annotateKey, Map<String, Object> paramsMap ){

        if ( annotateKey == null || "".equals(annotateKey) ){
            return null;
        }

        if (!annotateKey.contains(POINT)) {
            return paramsMap.get(annotateKey).toString();
        }

        String cacheKey = null;
        String[] keys = annotateKey.split("/.");

        Map<String, Object> copyParamsMap = new HashMap<>(paramsMap.size());
        CopyUtil.copyBean(paramsMap, copyParamsMap);

        for (int i = 0; i < keys.length; i++) {

            Object keyMap = copyParamsMap.get(keys[i]);
            if ( keyMap == null || "".equals(keyMap)) {
                break;
            }

            if (i >= keys.length - 1) {
                cacheKey = String.valueOf(keyMap);
                break;
            }

            String keyMapStr = JSON.toJSONString(keyMap);
            copyParamsMap = JSONObject.parseObject(keyMapStr);
        }

        return cacheKey;
    }

    @After("point()")
    public void doAfter(JoinPoint point) {
//        // 接口结束后换行，方便分割查看
//        log.info("=========================================== End ===========================================");
    }

    @AfterReturning("point()")
    public void afterReturning(JoinPoint point) {
    }

    @AfterThrowing("point()")
    public void afterThrowing(JoinPoint point) {
    }
}
