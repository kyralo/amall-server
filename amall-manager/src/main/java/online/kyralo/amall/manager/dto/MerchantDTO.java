package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

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
public class MerchantDTO extends Base {

    /**
     * 商家ID
     */
    private String id;

    /**
     * 商家用户名
     */
    private String name;

    /**
     * 商家邮箱
     */
    private String mail;

    /**
     * 商家密码
     */
    private String password;

    /**
     * 商家店名
     */
    private String storeName;

    /**
     * 商家负责人电话
     */
    private String telephone;

    /**
     * 商家业务经营说明
     */
    private String info;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 0表示男, 1表示女, 2表示未知
     */
    private Integer sex;

    /**
     * 商家头像 (默认路径 “/avatar/boy.jpg”)
     */
    private String avatarUrl;

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