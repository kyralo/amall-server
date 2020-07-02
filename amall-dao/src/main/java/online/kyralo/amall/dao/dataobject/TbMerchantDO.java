package online.kyralo.amall.dao.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 商家
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_merchant")
public class TbMerchantDO {

    /**
     * 商家ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 商家用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 商家邮箱
     */
    @Column(name = "mail")
    private String mail;

    /**
     * 商家密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 商家店名
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 商家负责人电话
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * 商家业务经营说明
     */
    @Column(name = "info")
    private String info;

    /**
     * 商家地址
     */
    @Column(name = "address")
    private String address;

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