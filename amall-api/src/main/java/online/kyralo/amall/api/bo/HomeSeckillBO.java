package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 19:40
 * \* Description: 秒杀
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HomeSeckillBO extends Base {

    /**
     * 正在执行的 整点场 秒杀
     */
    private String seckillClock;

    /**
     * 秒杀 列表
     */
    private List<CommodityBO> commodities;
}
