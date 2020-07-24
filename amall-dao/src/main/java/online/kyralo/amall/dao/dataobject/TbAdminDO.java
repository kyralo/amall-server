package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "tb_admin")
public class TbAdminDO {

    /**
     * 管理员ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 管理员用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 管理员邮箱
     */
    @Column(name = "mail")
    private String mail;

    /**
     * 管理员密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 管理员电话
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 0表示男, 1表示女, 2表示未知
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 管理员头像 (默认路径 “/avatar/boy.jpg”)
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 超级管理员标识 (0,普通管理员  1,超级管理员)
     */
    @Column(name = "super_key")
    private Integer superKey;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    @Column(name = "status")
    private Integer status;

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