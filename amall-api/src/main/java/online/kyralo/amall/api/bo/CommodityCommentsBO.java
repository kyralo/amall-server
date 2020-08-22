package online.kyralo.amall.api.bo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/22
 * \* Time: 18:56
 * \* Description: 商品评论
 * \
 */
public class CommodityCommentsBO {

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
