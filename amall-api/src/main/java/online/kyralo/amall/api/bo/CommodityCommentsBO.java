package online.kyralo.amall.api.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/22
 * \* Time: 18:56
 * \* Description: 商品评论
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommodityCommentsBO  extends Base {

    /**
     * 商品平均评分
     */
    @ApiModelProperty("商品平均评分")
    private Integer rate;

    /**
     * 一级 用户评论
     */
    @ApiModelProperty("一级 用户评论")
    private List<TbUserCommentBO> primaryComments;

}
