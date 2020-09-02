package online.kyralo.amall.api;

import online.kyralo.amall.common.api.Res;

/**
 * @author wangchen
 */
public interface KindService {

    /**
     * 查询全部商品类型 列表
     * @return 商品类型 列表
     */
    Res<?> listKinds();

    /**
     * 查询商品类型 列表 通过商家ID
     * @param merchantId 商家ID
     * @return 商品类型 列表
     */
    Res<?> listKindsByMerchantId(String merchantId);
}
