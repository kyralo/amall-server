package online.kyralo.amall.manager.dto;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/11
 * \* Time: 16:30
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommoditySizeDTO extends Base {

    /**
     * 商品尺码自增ID
     */
    private Integer id;

    /**
     * SKU ID
     */
    private String skuId;

    /**
     * 商品尺码名
     */
    private String sizeName;

    /**
     * sku描述(商家对产品的描述) json存储 e.g: [{"name":"腰围", "value":"62-72"},{"name":"裤长", "value":"92"}]
     */
    private String sizeDesc;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Integer status;
}
