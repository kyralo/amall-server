package online.kyralo.amall.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

    @GetMapping
    public void pay(HttpServletResponse httpResponse) throws Exception {

        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                // 支付接口url
                "https://openapi.alipaydev.com/gateway.do",
                // appId
                "2021000116679344",
                // 应用的私钥
                "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHmPy6YH8pBblN5zyEtIowlcdJ0IHW6mcx6Onui98cWVp0UMO/AugnUsZ+9J7T5u8D5mFoM04Um0lZmyeJsjD3GeFdzuu8K6vwmbXU6H9gjUKRjyjzScBkuiBLo4RHyuLsdmDDpR/WxIW0mwFkJTy85GSgNe3Dc1dEpHD1J0+eJhioZuLS+eW8QvoM2DbCnBwSkkRoIcdiQQSpgpb+FKFUuQUe3g9EteL2s9DQt0f83MgO+hi/0LOM8RNsSsAQXm54spYy/C9NZA8OXESZhAlOf91nj99NtPPQPjG2kOI7o77jIzDngamhH0fr+YhrCofxWC9qPcwOJIM7/jg7j5bLAgMBAAECggEAeOhUacfDewusiKdokhf9pIbZVZtDOyR18c3yUY+M2NVfz5l4gWiRIwcvEWMEAITJmRuivWwJ8lvo0qqDXcdy29LK3n+0OWxjez1EIl1RvwEWW35gkFax498HDwr116I0J48Ch1FEi5dedYVFf0uo1fF9PFH5+S5uoTlTs3VjC+s2C11VvQVDV7zJ/VWZ3O6OwR63kDMkrUCvdSzGV0zg0y1kEQ8daVeXflwQXWA+mJfiSSftx5es81srysIh5ONeKsXJaX+GEUjoMpR/geeuyzocs4hGku3GWQg98lyTHJ782QGcOw0c6iBR0BYPah6O68JuEZyq5AxnVtG1d9LiMQKBgQC61p2iEqarhiAbTtpCg55tRKpojHk6/gAqOA1GvaR+ccuKYUK+kTobmDJNAQhX3wlqbOug2qB5xQjupfuI4dF0owyMbC2bB9VH1LR7/7GSoYk461Rp75poS7wUInVg3MJllE2YA1IzjuXWFvnG4Yllpob3P8ooBEPGMOgotsftowKBgQC5yqOxDjhIscCuKt6WOAqKtCPmHSOoZXBeWol2fKRoQqR7OZYnEYjbLMb0uD9zkkumR4kPf7SaF6L3TEqu1qqlkK19NYS5tNRuPHXfd4CQ69vatTRZFZdlbFLgq3oF61Gu7RIbpWp+Ecfpl5k3ldu92ARo3elqf4pF7uHpFW10uQKBgDOtjvY4MG967sB+4/HH0/cnKfc2+4UsokELNejeJXRv5zuEQWDSbH8bbrZL1dHwN/t+2wGn1wE3VYwkztkClNutCZiBh2+9D+oJVE6D38rN8VWUCcovYsb8Q65SBaNgDEjqZzfnm0H1gW7g9f9jfIxoLiaPN0wwOcrE1kIEpHH/AoGALQbiUwe6Nkv2AX/cQBXG4ES2Ko/HU4l6CTPx+qhMhAQars6PCFrkixG4ChkZL541/U969SmjEHFICp0PwH3AD64Xja/JweQEU88NViI1I2o19zRRQoHMFkWBdHe6c/LK8hT8fXzCaVlP1NnrxR/piIHw16Voa2oLjdVOJNoPk+kCgYBCQV8sLsc1BH4qhdLQVa9Muu++mWnaM6MVg9U8bdFy2lolGtX6IJx2ClFqGbEjHiu7bycFBCCs00KKxwhEuPrNChp0g5U7LiLP2naUXrmtHgc7OiT8p9A0g/wD1vnGkWKR3fUtiM9SSDQpomRtL8y5YMaivIOh2pTVExFsJq/7yA==",
                // 格式化编码
                "JSON",
                // 编码格式
                "utf-8",
                // 支付宝的公钥(在沙箱环境中可以获取)
                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB",
                // 签名的算法
                "RSA2"
        );

        // 创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        // 用户支付完比后跳转到页面，同步
        alipayRequest.setReturnUrl("https://www.baidu.com");

        // 用户支付成功异步通知的请求
        // 在公共参数中设置回跳和通知地址
        alipayRequest.setNotifyUrl("https://www.baidu.com");

        /*
            Order order = new Order()
            order.setTotalPrice(BigDecimal.valueOf(34409.2))
        */

        // 订单的信息都是封装到下面的
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\" 37273878 \"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + 0.01 + "," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }" +
                "  }");//填充业务参数


        String form = "";
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + "utf-8");
        //直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

}
