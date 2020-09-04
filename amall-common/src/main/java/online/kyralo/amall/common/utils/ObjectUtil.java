package online.kyralo.amall.common.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/3
 * \* Time: 21:03
 * \* Description: 对象工具类
 * \
 */
@Component
public class ObjectUtil {

    /**
     * 通过反射方式 根据对象属性名称获取属性值
     * @param fieldName 对象属性名称
     * @param fieldClass 对象属性类型
     * @param object 对象
     * @return 对象属性值
     */
    public static <T> T getFieldValueByFieldName(String fieldName, Class<T> fieldClass, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //对private的属性的访问
            field.setAccessible(true);

            return fieldClass.cast(field.get(object));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
