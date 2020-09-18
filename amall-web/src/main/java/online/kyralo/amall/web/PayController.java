package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.PayService;
import online.kyralo.amall.api.model.PayModel;
import online.kyralo.amall.common.api.Res;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/8
 * \* Time: 14:54
 * \* Description: 支付接口
 * \
 */
@RestController
@RequestMapping("/api/v1/pay")
@Api(tags = "支付")
@Validated
public class PayController {

    @Resource
    private PayService payService;

    @GetMapping
    public Res<?> payDemo(HttpServletResponse httpResponse) throws IOException {

        PayModel<Object> payModel = PayModel.builder()
                .outTradeNo(UUID.randomUUID().toString().replace("-",""))
                .productCode("FAST_INSTANT_TRADE_PAY")
                .subject("Iphone6 16G")
                .body("Iphone6 16G")
                .extendParams(null)
                .passbackParams("merchantBizType%3d3C%26merchantBizNo%3d2016010101111")
                .totalAmount(0.01)
                .build();

        Res<?> alipay = payService.alipay(payModel);

        httpResponse.setContentType("text/html;charset=" + "utf-8");
        //直接将完整的表单html输出到页面
        httpResponse.getWriter().write(alipay.getData().toString());
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();

        return null;
    }

    @PostMapping
    public Res<?> notifyResult(@ApiParam("voucher_detail_list") @RequestBody List<?> voucherDetailList){
        System.out.println(voucherDetailList);
        return null;
    }

}
