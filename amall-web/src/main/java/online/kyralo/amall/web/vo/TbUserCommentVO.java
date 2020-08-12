package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;

/**
 * 用户评论
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbUserCommentVO", description = "用户评论模型")
public class TbUserCommentVO extends Base {

    /**
     * 用户评论id
     */
    @ApiModelProperty("用户评论id")
    private String id;

    /**
     * 商品SKU ID
     */
    @ApiModelProperty("商品SKU ID")
    private String skuId;

    /**
     * 发送者id
     */
    @ApiModelProperty("发送者id")
    private String sendId;

    /**
     * 要回复的评论id
     */
    @ApiModelProperty("要回复的评论id")
    private String answerCommentId;

    /**
     * 评论内容
     */
    @ApiModelProperty("评论内容")
    private String content;

    /**
     * 评论图片 多个图片逗号分隔
     */
    @ApiModelProperty("评论图片 多个图片逗号分隔")
    private String picUrls;

    /**
     * 评论评分 仅一级评论可评 1-5
     */
    @ApiModelProperty("评论评分 仅一级评论可评 1-5")
    private Integer mark;

    /**
     * 祖父评论(一级评论)的id
     */
    @ApiModelProperty("祖父评论(一级评论)的id")
    private String ancestryId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}