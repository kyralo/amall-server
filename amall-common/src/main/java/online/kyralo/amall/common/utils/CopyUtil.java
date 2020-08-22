package online.kyralo.amall.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 12:18
 * \* Description: 复制
 * \
 */
public class CopyUtil {

    public static <T> List<T> copyList(Object list, Class<T> tClass) {
        if (list == null) {
            return new ArrayList<>();
        }
        return JSON.parseArray(JSON.toJSONString(list), tClass);
    }

    public static Map<String, Object> copyMap(Map<String, Object> map) {
        if (map == null) {
            return new HashMap<>(0);
        }
        return JSON.parseObject(JSON.toJSONString(map));
    }

    public static <T> T copyMapToObject(Map<String, Object> map, Class<T> tClass) {
        return JSON.parseObject(JSON.toJSONString(map), tClass);
    }

    public static <S, T> void copyBean(S source, T target) {
        if (source == null) {
            return;
        }
        BeanUtils.copyProperties(source, target);
    }
}
