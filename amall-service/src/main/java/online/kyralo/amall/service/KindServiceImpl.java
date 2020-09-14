package online.kyralo.amall.service;

import online.kyralo.amall.api.KindService;
import online.kyralo.amall.common.api.Res;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/27
 * \* Time: 6:33
 * \* Description: 商品类型
 * \
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class KindServiceImpl implements KindService {
    @Override
    public Res<?> listKinds() {
        return null;
    }

    @Override
    public Res<?> listKindsByMerchantId(String merchantId) {
        return null;
    }
}
