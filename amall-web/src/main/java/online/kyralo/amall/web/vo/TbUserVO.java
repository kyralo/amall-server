package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@ApiModel(value = "TbUserVO", description = "用户模型")
public class TbUserVO {

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 用户邮箱
     */
    @ApiModelProperty("用户邮箱")
    private String mail;

    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 用户电话
     */
    @ApiModelProperty("用户电话")
    private String telephone;

    /**
     * 0表示男, 1表示女, 2表示未知
     */
    @ApiModelProperty("0表示男, 1表示女, 2表示未知")
    private Integer sex;

    /**
     * 用户头像 (默认路径 “/avatar/boy.jpg”)
     */
    @ApiModelProperty("用户头像 (默认路径 “/avatar/boy.jpg”)")
    private String avatarUrl;

    /**
     * 是否为vip,0表示是,1表示不是, 默认为0
     */
    @ApiModelProperty("是否为vip,0表示是,1表示不是, 默认为0")
    private boolean vip;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Integer status;

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