package online.kyralo.amall.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/15
 * \* Time: 15:25
 * \* Description:
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PayModel<T> extends Base {

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "product_code")
    private String productCode;

    @JSONField(name = "total_amount")
    private Double totalAmount;

    @JSONField(name = "subject")
    private String subject;

    @JSONField(name = "body")
    private T body;

    @JSONField(name = "passback_params")
    private String passbackParams;

    @JSONField(name = "extend_params")
    private String extendParams;
}
