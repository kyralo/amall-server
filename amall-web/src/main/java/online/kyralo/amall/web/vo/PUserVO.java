package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/4
 * \* Time: 21:39
 * \* Description: PC 用户端 用户信息页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PUserVO", description = "用户页面模型")
public class PUserVO extends Base {
    private String id;
}
