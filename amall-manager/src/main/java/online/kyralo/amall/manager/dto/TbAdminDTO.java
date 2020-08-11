package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;

/**
 * 管理员
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TbAdminDTO extends Base {

    /**
     * 管理员ID
     */
    private String id;

    /**
     * 管理员用户名
     */
    private String name;

    /**
     * 管理员邮箱
     */
    private String mail;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 管理员电话
     */
    private String telephone;

    /**
     * 0表示男, 1表示女, 2表示未知
     */
    private Integer sex;

    /**
     * 管理员头像 (默认路径 “/avatar/boy.jpg”)
     */
    private String avatarUrl;

    /**
     * 超级管理员标识 (0,普通管理员  1,超级管理员)
     */
    private Integer superKey;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}