package online.kyralo.amall.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 12:18
 * \* Description: 复制
 * \
 */

@Component
public class CopyUtil  implements ApplicationContextAware {

    /**
     * 当前IOC
     */
    private static ApplicationContext context;

    /**
     * 设置当前上下文环境，此方法由spring自动装配
     */
    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    /**
     * 从当前IOC获取bean
     * @param id bean的id
     * @return bean
     */
    private static Object getObject(String id) {
        return context.getBean(id);
    }

    /**
     * 获取不为空的属性
     * @param source 源 object
     * @return 不为空的属性
     */
    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 拷贝集合
     * @param list 集合
     * @param tClass 类型
     * @param <T> 泛型
     * @return 集合
     */
    public static <T> List<T> copyList(Object list, Class<T> tClass) {
        if (list == null) {
            return new ArrayList<>();
        }
        return JSON.parseArray(JSON.toJSONString(list), tClass);
    }

    /**
     * 拷贝 map
     * @param map map
     * @return map
     */
    public static Map<String, Object> copyMap(Map<String, Object> map) {
        if (map == null) {
            return new HashMap<>(0);
        }
        return JSON.parseObject(JSON.toJSONString(map));
    }

    /**
     * 拷贝 map 为 object
     * @param map map
     * @param tClass 类型
     * @param <T> 泛型
     * @return 拷贝的map
     */
    public static <T> T copyMapToObject(Map<String, Object> map, Class<T> tClass) {
        return JSON.parseObject(JSON.toJSONString(map), tClass);
    }

    /**
     * Spring BeanUtils 拷贝增强 , 为空的属性不进行拷贝
     * @param source 源 object
     * @param target 目标 object
     * @param <S> 源泛型
     * @param <T> 目标泛型
     */
    public static <S, T> void copyBean(S source, T target) {
        if (source == null) {
            return;
        }
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }
}
