package online.kyralo.amall.manager.dto;

import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/30
 * \* Time: 11:43
 * \* Description: 套餐
 * \
 */
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComboDTO extends Base {

    /**
     * 套餐ID
     */
    private String comboId;

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
