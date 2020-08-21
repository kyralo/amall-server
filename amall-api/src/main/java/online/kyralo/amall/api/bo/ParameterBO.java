package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 1:23
 * \* Description:
 * \
 */
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParameterBO<T> extends Base {
    /**
     * 商品参数名
     */
    private String name;
    /**
     * 商品参数值
     */
    private T value;
}