package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "tb_user_comment")
public class TbUserCommentDO {

    /**
     * 用户评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 商品SKU ID
     */
    @Column(name = "sku_id")
    private String skuId;

    /**
     * 发送者id
     */
    @Column(name = "send_id")
    private String sendId;

    /**
     * 要回复的评论id
     */
    @Column(name = "answer_comment_id")
    private String answerCommentId;

    /**
     * 评论内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 评论图片 多个图片逗号分隔
     */
    @Column(name = "pic_urls")
    private String picUrls;

    /**
     * 评论评分 仅一级评论可评 1-5
     */
    @Column(name = "mark")
    private Integer mark;

    /**
     * 祖父评论(一级评论)的id
     */
    @Column(name = "ancestry_id")
    private String ancestryId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}