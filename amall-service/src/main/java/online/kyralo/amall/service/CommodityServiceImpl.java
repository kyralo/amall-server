package online.kyralo.amall.service;

import online.kyralo.amall.api.CommodityService;
import online.kyralo.amall.api.model.ComboModel;
import online.kyralo.amall.common.annotation.NewCache;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.constants.CacheEnum;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.RedisUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.manager.dto.ComboDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static online.kyralo.amall.common.constants.CommodityConstant.CACHE_COMMODITY_COMBO_PREFIX;
import static online.kyralo.amall.common.constants.RedisConstant.CACHE_TB_KEY_PREFIX;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 20:15
 * \* Description: 商品
 * \
 */

@Service
public class CommodityServiceImpl implements CommodityService {

    @NewCache(value = CACHE_TB_KEY_PREFIX + "commodity", key = "commoditySkuId", type = CacheEnum.QUERY)
    @Override
    public Res<?> queryById(String commoditySkuId) {
        return null;
    }

    @Override
    public Res<?> listByCategory(String primaryType, String secondType) {
        return null;
    }

    @Override
    public Res<?> listHomeShowModules() {
        return null;
    }

    @Override
    public Res<?> listHomeRecommondCommodities(String userId) {

        if ("".equals(userId)) {
            System.out.println("----");
        }

        return null;
    }

    @Override
    public Res<?> listRecommondCommodities(String commoditySkuId) {
        return null;
    }

    @Override
    public Res<?> listMerchantRecommondCommodities(String commoditySkuId) {
        return null;
    }

    @Override
    public Res<?> insertCommodityCombo(String commoditySkuId, ComboModel comboModel) {

        String comboId = UUID.randomUUID().toString().replace("-", "");
        RedisUtil.putHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId, comboModel);

        return ResUtil.success();
    }

    @Override
    public Res<?> updateCommodityCombo(String commoditySkuId, ComboModel comboModel) {

        String comboId = comboModel.getComboId();
        Object result = RedisUtil.getHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId);

        if (result == null) {
            return ResUtil.error();
        }

        CopyUtil.copyBean(comboModel, result);
        RedisUtil.putHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId, result);

        return ResUtil.success();
    }

    @Override
    public Res<?> deleteCommodityCombo(String commoditySkuId, String comboId) {

        Object result = RedisUtil.getHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId);

        if (result == null) {
            return ResUtil.error();
        }

        if (RedisUtil.removeHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId) <= 0) {
            return ResUtil.error();
        }

        return ResUtil.success();
    }

}
