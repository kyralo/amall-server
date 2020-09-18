package online.kyralo.amall.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import online.kyralo.amall.api.PayService;
import online.kyralo.amall.api.model.PayModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.ResUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/8
 * \* Time: 8:51
 * \* Description: 支付
 * \
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private AlipayClient alipayClient;

    @Resource(name = "alipayTradePagePayRequest")
    private AlipayTradePagePayRequest alipayRequest;

    @Override
    public Res<?> alipay(PayModel<Object> payModel) {

         /*
            Order order = new Order()
            order.setTotalPrice(BigDecimal.valueOf(34409.2))
        */

        String json = JSON.toJSONString(payModel);

        // 订单的信息都是封装到下面的
        //填充业务参数
        alipayRequest.setBizContent(json);

        String form = null;
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return ResUtil.success(form);
    }
}
