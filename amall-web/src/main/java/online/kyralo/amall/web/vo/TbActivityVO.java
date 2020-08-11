package online.kyralo.amall.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/6
 * \* Time: 22:54
 * \* Description: 活动
 * \
 */
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbActivityVO", description = "活动模型")
public class TbActivityVO extends Base {

    /**
     * 活动id
     */
    @ApiModelProperty("活动ID")
    private String id;

    /**
     * 活动名
     */
    @ApiModelProperty("活动名")
    private String name;

    /**
     * 活动大图
     */
    @ApiModelProperty("活动大图")
    private String picUrl;

    /**
     * 活动类型
     */
    @ApiModelProperty("活动类型")
    private String type;
}
