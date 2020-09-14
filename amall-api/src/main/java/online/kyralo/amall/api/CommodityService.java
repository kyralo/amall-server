package online.kyralo.amall.api;

import online.kyralo.amall.api.model.ComboModel;
import online.kyralo.amall.common.api.Res;

/**
 * @author wangchen
 */
public interface CommodityService {

    /**
     * 查询商品信息 通过商品 sku id
     *
     * @param commoditySkuId 商品 sku id
     * @return 商品信息
     */
    Res<?> queryById(String commoditySkuId);

    /**
     * 查询商品 通过商品类型
     * @param primaryType 一级类型
     * @param secondType 二级类型
     * @return 商品列表
     */
    Res<?> listByCategory(String primaryType, String secondType);

    /**
     * 查询主页展示模块
     *
     * @return 主页展示模块
     */
    Res<?> listHomeShowModules();

    /**
     * 查询推荐商品 列表 主页
     *
     * @param userId 用户ID
     * @return 主页 推荐商品
     */
    Res<?> listHomeRecommondCommodities(String userId);

    /**
     * 查询[同类]推荐商品 列表 商品页 [系统推荐]
     *
     * @param commoditySkuId 商品skuId
     * @return 商品页 [同类]推荐商品
     */
    Res<?> listRecommondCommodities(String commoditySkuId);

    /**
     * 查询商家推荐商品 列表 商品页 [固定数]
     *
     * @param commoditySkuId 商品skuId
     * @return 商品页 商家推荐商品
     */
    Res<?> listMerchantRecommondCommodities(String commoditySkuId);

    /**
     * 新增商品套餐
     *
     * @param commoditySkuId 商品skuId
     * @param comboModel 套餐
     * @return 是否更改成功
     */
    Res<?> insertCommodityCombo(String commoditySkuId, ComboModel comboModel);

    /**
     * 更改商品套餐
     *
     * @param commoditySkuId 商品skuId
     * @param comboModel 套餐
     * @return 是否更改成功
     */
    Res<?> updateCommodityCombo(String commoditySkuId, ComboModel comboModel);

    /**
     * 删除商品套餐
     *
     * @param commoditySkuId 商品skuId
     * @param comboId 套餐ID
     * @return 是否更改成功
     */
    Res<?> deleteCommodityCombo(String commoditySkuId, String comboId);
}
