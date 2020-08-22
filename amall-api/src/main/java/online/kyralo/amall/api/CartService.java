package online.kyralo.amall.api;

import online.kyralo.amall.common.api.Res;

/**
 * @author wangchen
 */
public interface CartService {

    /**
     * 查询购物车 通过用户ID
     *
     * @param userId 用户ID
     * @return 购物车
     */
    Res<?> findById(String userId);

    /**
     * 新增 购物车
     *
     * @param userId      用户ID
     * @param commodityId 商品 sku id
     * @param addCount    添加数量
     * @return 新增的状态
     */
    Res<?> insert(String userId, String commodityId, Integer addCount);

    /**
     * 更新 购物车 商品数量
     *
     * @param userId      用户ID
     * @param commodityId 商品 sku id
     * @param addCount    添加数量
     * @return 更新的状态
     */
    Res<?> updateAddCount(String userId, String commodityId, Integer addCount);

    /**
     * 删除商品 购物车
     *
     * @param userId      用户ID
     * @param commodityId 商品 sku id
     * @return 删除的状态
     */
    Res<?> remove(String userId, String commodityId);

    /**
     * 统计商品
     *
     * @param userId 用户ID
     * @return 统计数
     */
    Res<?> countByUserId(String userId);
}
