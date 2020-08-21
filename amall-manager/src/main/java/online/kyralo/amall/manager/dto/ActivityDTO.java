package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 1:07
 * \* Description:
 * \
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    /**
     * 活动id
     */
    private String id;

    /**
     * 活动名
     */
    private String name;

    /**
     * 活动大图
     */
    private String picUrl;

    /**
     * 活动目标ID
     */
    private Object targetId;

    /**
     * 活动类型
     */
    private String type;

    /**
     * 活动状态 1:有效, 0:失效, -1:下架
     */
    private Integer status;

    /**
     * 活动 有效天数
     */
    private Integer deadDays;

    /**
     * 创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
