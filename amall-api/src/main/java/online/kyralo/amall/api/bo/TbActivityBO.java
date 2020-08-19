package online.kyralo.amall.api.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/19
 * \* Time: 19:55
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TbActivityBO extends Base {
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
