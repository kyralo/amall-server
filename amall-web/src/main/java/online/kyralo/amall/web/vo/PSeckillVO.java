package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/4
 * \* Time: 21:44
 * \* Description: PC 用户端 秒杀页面
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PSeckillVO", description = "秒杀页面模型")
public class PSeckillVO extends Base {
}
