package online.kyralo.amall.manager.dto;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/10
 * \* Time: 10:40
 * \* Description:
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDTO<T> extends Base {

    /**
     * 商品参数名
     */
    private String name;
    /**
     * 商品参数值
     */
    private T value;

}