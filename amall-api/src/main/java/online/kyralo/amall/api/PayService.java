package online.kyralo.amall.api;

import online.kyralo.amall.api.model.PayModel;
import online.kyralo.amall.common.api.Res;

/**
 * @author wangchen
 */
public interface PayService {

    /**
     * 支付
     * @param payModel 支付信息
     * @return 支付的状态
     */
    Res<?> alipay(PayModel<Object> payModel);
}
