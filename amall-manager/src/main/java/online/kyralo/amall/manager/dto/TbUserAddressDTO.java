package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class TbUserAddressDTO extends Base {

    /**
     * 用户地址ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区/县
     */
    private String district;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 详细地址
     */
    private String location;

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