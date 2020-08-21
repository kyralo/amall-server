package online.kyralo.amall.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
        return JSON.parseArray(JSON.toJSONString(list), tClass);
    }

    public static Map<String, Object> copyMap(Map<String, Object> map) {
        return JSON.parseObject(JSON.toJSONString(map));
    }

    public static <S, T> void copyBean(S source, T target) {
        if (source == null) {
            return;
        }
        BeanUtils.copyProperties(source, target);
    }
}
