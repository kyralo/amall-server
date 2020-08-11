package online.kyralo.amall.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;

/**
 * 用户地址
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TbUserAddressVO", description = "用户地址模型")
public class TbUserAddressVO extends Base {

    /**
     * 用户地址ID
     */
    @ApiModelProperty("用户地址ID")
    private Integer id;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;

    /**
     * 省份
     */
    @ApiModelProperty("省份")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty("城市")
    private String city;

    /**
     * 区/县
     */
    @ApiModelProperty("区/县")
    private String district;

    /**
     * 邮编
     */
    @ApiModelProperty("邮编")
    private String zipCode;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String location;

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