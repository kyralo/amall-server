package online.kyralo.amall.manager;

import online.kyralo.amall.common.utils.RedisUtil;
import org.springframework.stereotype.Component;

import java.util.List;

import static online.kyralo.amall.common.constants.CommodityConstant.CACHE_COMMODITY_SERVICE_INFO;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/11
 * \* Time: 17:14
 * \* Description: 商家
 * \
 */

@Component
public class MerchantManager {

    public Boolean addCommodityServiceInfo(String commoditySkuId, List<String> serviceInfos){

        if (serviceInfos.isEmpty()) {
            return false;
        }

        RedisUtil.putHash(CACHE_COMMODITY_SERVICE_INFO, commoditySkuId, serviceInfos);

        return true;
    }
}
