package online.kyralo.amall.common.utils;

import online.kyralo.amall.common.constants.SortEnum;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 20:04
 * \* Description: Redis工具类
 * \
 */

@Component
public class RedisUtil {

    private static RedisTemplate<String, Object> template;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void init() {
        template = this.redisTemplate;
    }

    // > template

    public static RedisTemplate<String, Object> getTemplate() {
        return template;
    }

    // > expire

    public static Boolean expire(String key, long timeout, TimeUnit unit) {
        return template.expire(key, timeout, unit);
    }

    // > String

    public static void setString(String key, Object value) {
        template.opsForValue().set(key, value);
    }

    public static Boolean setString(String key, Object value, long timeout, TimeUnit unit) {
        template.opsForValue().set(key, value);
        return template.expire(key, timeout, unit);
    }

    public static Object getString(String key) {
        return template.opsForValue().get(key);
    }

    // > Hash

    public static void putHash(String key, Object hashKey, Object value) {
        template.opsForHash().put(key, hashKey, value);
    }

    public static void putExpireHash(String key, Object hashKey, Object value, long timeout, TimeUnit unit) {
        template.opsForHash().put(key, hashKey, value);
        template.expire(key, timeout, unit);
    }

    public static Object getHash(String key, Object hashKey) {
        return template.opsForHash().get(key, hashKey);
    }

    public static Long removeHash(String key, Object hashKey) {
        return template.opsForHash().delete(key, hashKey);
    }

    // > Zset

    public static Boolean addZset(String key, Object value, Double v) {
        return template.opsForZSet().add(key, value, v);
    }

    public static Set<Object> getZset(String key, Long l1, Long l2) {
        return template.opsForZSet().range(key, l1, l2);
    }

    public static Set<Object> getPage(String cacheKey, Integer pageNum, Integer pageSize) {

        ZSetOperations<String, Object> operation = template.opsForZSet();

        long start = pageNum * pageSize;
        long end = (pageNum + 1) * pageSize;

        return operation.range(cacheKey, start, end);
    }

    public static Set<Object> getPage(String cacheKey, Integer pageNum, Integer pageSize, SortEnum order) {

        ZSetOperations<String, Object> operation = template.opsForZSet();

        long start = pageNum * pageSize;
        long end = (pageNum + 1) * pageSize;
        Long pageCount = template.opsForZSet().zCard(cacheKey);

        if (pageCount == null) {
            return null;
        }

        if (pageCount < start) {
            return null;
        }


        if (order == SortEnum.DESC) {
            return operation.reverseRange(cacheKey, start, end);
        }

        return operation.range(cacheKey, start, end);
    }

    public static Long getPageCount(String cacheKey) {
        return template.opsForZSet().zCard(cacheKey);
    }

    public static Boolean removeZsetElement(String cacheKey, Object o) {
        Long remove = template.opsForZSet().remove(cacheKey, o);
        return !(remove == null || remove <= 0);
    }

}
