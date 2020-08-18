package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/14
 * \* Time: 0:12
 * \* Description: 广告 数据模型
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PAdvertisingVO extends Base {

    /**
     * 广告ID
     */
    @ApiModelProperty("广告ID")
    private String id;

    /**
     * 广告类型
     */
    @ApiModelProperty("广告类型")
    private String type;

    /**
     * 广告封面图
     */
    @ApiModelProperty("广告封面图")
    private String imgUrl;

    /**
     * 广告 目的地ID [e.g 商品广告 --> 商品ID ]
     */
    @ApiModelProperty("秒杀 广告")
    private String destinationId;

}
