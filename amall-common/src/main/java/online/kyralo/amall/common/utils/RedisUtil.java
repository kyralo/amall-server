package online.kyralo.amall.common.utils;

import org.springframework.data.redis.core.RedisTemplate;
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

    public static Boolean setExpireString(String key, Object value, long timeout, TimeUnit unit) {
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

    public static void removeHash(String key, Object hashKey) {
        template.opsForHash().delete(key, hashKey);
    }

    // > Zset

    public static void addZset(String key, Object value, Double v) {
        template.opsForZSet().add(key, value, v);
    }

    public static Set<Object> getZset(String key, Long l1, Long l2) {
        return template.opsForZSet().range(key, l1, l2);
    }

}
