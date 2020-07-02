package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@ApiModel(value = "TbMerchantVO", description = "商家模型")
public class TbMerchantVO {

    /**
     * 商家ID
     */
    @ApiModelProperty("商家ID")
    private String id;

    /**
     * 商家用户名
     */
    @ApiModelProperty("商家用户名")
    private String name;

    /**
     * 商家邮箱
     */
    @ApiModelProperty("商家邮箱")
    private String mail;

    /**
     * 商家密码
     */
    @ApiModelProperty("商家密码")
    private String password;

    /**
     * 商家店名
     */
    @ApiModelProperty("商家店名")
    private String storeName;

    /**
     * 商家负责人电话
     */
    @ApiModelProperty("商家负责人电话")
    private String telephone;

    /**
     * 商家业务经营说明
     */
    @ApiModelProperty("商家业务经营说明")
    private String info;

    /**
     * 商家地址
     */
    @ApiModelProperty("商家地址")
    private String address;

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