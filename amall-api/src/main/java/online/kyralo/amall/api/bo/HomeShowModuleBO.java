package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 19:52
 * \* Description:
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HomeShowModuleBO extends Base {
    /**
     * 展示图
     */
    private String picUrl;

    /**
     * 类型
     */
    private CommodityKindBO showModuleKind;

    /**
     * 商品 列表
     */
    private List<CommodityBO> commodities;

    /**
     * 热销商品 列表
     */
    private List<CommodityBO> hotCommodities;
}
