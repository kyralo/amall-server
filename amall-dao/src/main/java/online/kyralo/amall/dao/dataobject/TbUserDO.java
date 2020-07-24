package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "tb_user")
public class TbUserDO {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户邮箱
     */
    @Column(name = "mail")
    private String mail;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户电话
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 0表示男, 1表示女, 2表示未知
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 用户头像 (默认路径 “/avatar/boy.jpg”)
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 是否为vip,0表示是,1表示不是, 默认为0
     */
    @Column(name = "is_vip")
    private Boolean vip;

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