package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * 第三方用户信息
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbAccountPlatformVO", description = "第三方用户信息模型")
public class TbAccountPlatformVO {

    /**
     * 自增id
     */
    @ApiModelProperty("自增id")
    private String id;

    /**
     * 账号id
     */
    @ApiModelProperty("账号id")
    private String uid;

    /**
     * 平台id
     */
    @ApiModelProperty("平台id")
    private String platformId;

    /**
     * 平台access_token
     */
    @ApiModelProperty("平台access_token")
    private String platformToken;

    /**
     * 平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter
     */
    @ApiModelProperty("平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter")
    private Integer type;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

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