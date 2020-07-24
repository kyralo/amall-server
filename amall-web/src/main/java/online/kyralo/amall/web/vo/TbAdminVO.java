package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@ApiModel(value = "TbAdminVO", description = "管理员模型")
public class TbAdminVO {

    /**
     * 管理员ID
     */
    @ApiModelProperty("管理员ID")
    private String id;

    /**
     * 管理员用户名
     */
    @ApiModelProperty("管理员用户名")
    private String name;

    /**
     * 管理员邮箱
     */
    @ApiModelProperty("管理员邮箱")
    private String mail;

    /**
     * 管理员密码
     */
    @ApiModelProperty("管理员密码")
    private String password;

    /**
     * 管理员电话
     */
    @ApiModelProperty("管理员电话")
    private String telephone;

    /**
     * 0表示男, 1表示女, 2表示未知
     */
    @ApiModelProperty("0表示男, 1表示女, 2表示未知")
    private Integer sex;

    /**
     * 管理员头像 (默认路径 “/avatar/boy.jpg”)
     */
    @ApiModelProperty("管理员头像 (默认路径 “/avatar/boy.jpg”)")
    private String avatarUrl;

    /**
     * 超级管理员标识 (0,普通管理员  1,超级管理员)
     */
    @ApiModelProperty("超级管理员标识 (0,普通管理员  1,超级管理员)")
    private Integer superKey;

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