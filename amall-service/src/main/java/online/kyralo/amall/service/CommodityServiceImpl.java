package online.kyralo.amall.service;

import online.kyralo.amall.api.CommodityService;
import online.kyralo.amall.common.api.Res;
import org.springframework.stereotype.Service;

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

    @Override
    public Res<?> queryById(String commoditySkuId) {
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

}
