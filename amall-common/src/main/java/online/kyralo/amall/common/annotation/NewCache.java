package online.kyralo.amall.common.annotation;

import online.kyralo.amall.common.constants.CacheEnum;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author wangchen
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NewCache {

    /**
     * 缓存名称
     */
    String value();

    /**
     * 缓存键
     */
    String key();

    /**
     * 缓存类型 QUERY 查询, UPDATE 修改, DELETE 删除
     */
    CacheEnum type();

    /**
     * 缓存时间 (默认为7天)
     */
    long timeout() default 7;

    /**
     * 缓存时间单位 (默认为天)
     */
    TimeUnit timeunit() default TimeUnit.DAYS;

    /**
     * 描述信息
     */
    String description() default "";
}
