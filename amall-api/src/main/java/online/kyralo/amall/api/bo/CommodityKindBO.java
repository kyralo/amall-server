package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 1:14
 * \* Description: 商品分类
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommodityKindBO extends Base {

    /**
     * 一级类型
     */
    private TbCommodityCategoryBO primaryCategory;
    /**
     * 二级类型 列表
     */
    private List<TbCommodityCategoryBO> secondCategories;
}
