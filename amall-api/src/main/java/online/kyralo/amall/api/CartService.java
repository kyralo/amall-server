package online.kyralo.amall.api;

import online.kyralo.amall.common.api.Res;

/**
 * @author wangchen
 */
public interface CartService {

    /**
     * 新增 购物车
     *
     * @param userId      用户ID
     * @param commodityId 商品 SKU ID
     * @param commodityStockId 商品库存 ID
     * @param addCount    添加数量
     * @return 新增的状态
     */
    Res<?> insert(String userId, String commodityId, Integer commodityStockId, Integer addCount);

    /**
     * 更新 购物车 商品数量
     *
     * @param userId      用户ID
     * @param commodityId 商品 SKU ID
     * @param commodityStockId 商品库存 ID
     * @param addCount    添加数量
     * @return 更新的状态
     */
    Res<?> updateAddCount(String userId, String commodityId, Integer commodityStockId, Integer addCount);

    /**
     * 删除商品 购物车
     *
     * @param userId      用户ID
     * @param commodityId 商品 SKU ID
     * @param commodityStockId 商品库存 ID
     * @return 删除的状态
     */
    Res<?> remove(String userId, String commodityId, Integer commodityStockId);

    /**
     * 统计商品
     *
     * @param userId 用户ID
     * @return 统计数
     */
    Res<?> countByUserId(String userId);


    /**
     * 查询用户购物车商品 列表
     *
     * @param userId 用户ID
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return 用户购物车商品
     */
    Res<?> listCartByUserId(String userId, Integer pageNum, Integer pageSize);
}
