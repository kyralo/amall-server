package online.kyralo.amall.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.RedisUtil;
import online.kyralo.amall.manager.dto.CartDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static online.kyralo.amall.common.constants.CartConstant.*;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 1:39
 * \* Description: 购物车 复合查询
 * \
 */

@Component
public class CartManager {

    private String getHashKey(String commodityId, Integer commodityStockId) {
        return commodityId + "_" + commodityStockId;
    }


    public Integer insert(String userId, String commodityId, Integer commodityStockId, Integer addCount) {

        String cacheKey = CACHE_CART_PREFIX + userId;

        Map<String, Object> map = new HashMap<>(2);
        map.put("commodityId", commodityId);
        map.put("commodityStockId", commodityStockId);
        map.put("addCount", addCount);

        long v = System.currentTimeMillis();

        // Hash 管理购物车商品数量
        String objectCacheKey = CACHE_CART_HASH_PREFIX + userId;
        String hashKey = getHashKey(commodityId, commodityStockId);

        RedisUtil.putHash(objectCacheKey, hashKey, map);

        // Zset 进行排序分页等操作
        Boolean isSuccess = RedisUtil.addZset(cacheKey, hashKey, (double) v);

        if (isSuccess) {
            return 1;
        }

        return 0;
    }

    public Integer updateAddCount(String userId, String commodityId, Integer commodityStockId, Integer addCount) {

        String cacheKey = CACHE_CART_HASH_PREFIX + userId;
        String hashKey = getHashKey(commodityId, commodityStockId);

        Object result = RedisUtil.getHash(cacheKey, hashKey);

        if (result == null) {
            return 0;
        }

        Map<String, Object> map = JSONObject.parseObject(JSON.toJSONString(result));
        map.put("addCount", addCount);

        return 1;
    }

    public Integer remove(String userId, String commodityId, Integer commodityStockId) {

        if (RedisUtil.removeZsetElement(CACHE_CART_PREFIX + userId, getHashKey(commodityId, commodityStockId))) {
            return 1;
        }

        return 0;
    }

    @Transactional(readOnly = true)
    public Long countByUserId(String userId) {
        return RedisUtil.getPageCount(CACHE_CART_PREFIX + userId);
    }

    @Transactional(readOnly = true)
    public List<CartDTO> listCartByUserId(String userId, Integer pageNum, Integer pageSize) {

        Set<Object> result = RedisUtil.getPage(CACHE_CART_PREFIX + userId, pageNum, pageSize);

        if (result.isEmpty()) {
            return null;
        }

        return CopyUtil.copyList(result, CartDTO.class);
    }

}
