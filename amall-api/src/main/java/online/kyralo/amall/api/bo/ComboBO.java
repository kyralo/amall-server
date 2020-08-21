package online.kyralo.amall.api.bo;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/20
 * \* Time: 1:27
 * \* Description: TODO
 * \
 */
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComboBO extends Base {

    /**
     * 套餐名
     */
    private String comboName;

    /**
     * 套餐说明
     */
    private String desc;

    /**
     * 套餐组合条件 颜色列表
     */
    private List<String> colorNames;

    /**
     * 套餐价格
     */
    private Double price;

    /**
     * 套餐折扣
     */
    private Float discount;

    /**
     * 套餐存货
     */
    private Integer stock;

}
