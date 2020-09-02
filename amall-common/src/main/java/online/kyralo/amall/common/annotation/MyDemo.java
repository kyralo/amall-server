package online.kyralo.amall.common.annotation;

import java.lang.annotation.*;

/**
 * @author wangchen
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyDemo {

    /**
     * 描述信息
     */
    String description() default "";

    /**
     * 描述id
     */
    String id() default "";
}
