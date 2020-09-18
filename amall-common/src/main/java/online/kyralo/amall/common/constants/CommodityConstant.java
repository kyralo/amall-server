package online.kyralo.amall.common.constants;

import org.springframework.stereotype.Component;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/11
 * \* Time: 17:29
 * \* Description: 商品常量
 * \
 */

@Component
public class CommodityConstant {

    /**
     * 商品商家服务说明缓存key
     */
    public static final String CACHE_COMMODITY_SERVICE_INFO = "amall_commodity_service_info";

    /**
     * 商品套餐key前缀
     */
    public static final String CACHE_COMMODITY_COMBO_PREFIX = "amall_commodity_combo_";

    /**
     * 商品折扣缓存前缀
     */
    public static final String CACHE_COMMODITY_DISCOUNT_PREFIX = "amall_commodity_discount_";

}
