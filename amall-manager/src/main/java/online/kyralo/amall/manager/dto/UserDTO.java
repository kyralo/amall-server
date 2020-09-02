package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;

/**
 * 用户
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends Base {

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户邮箱
     */
    private String mail;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户电话
     */
    private String telephone;

    /**
     * 0表示男, 1表示女, 2表示未知
     */
    private Integer sex;

    /**
     * 用户头像 (默认路径 “/avatar/boy.jpg”)
     */
    private String avatarUrl;

    /**
     * 是否为vip,0表示是,1表示不是, 默认为0
     */
    private boolean vip;

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