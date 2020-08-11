package online.kyralo.amall.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import online.kyralo.amall.common.base.domain.Base;

import java.util.Date;

/**
 * 用户收藏
 */

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TbUserCollectionDTO extends Base {

    /**
     * 用户地址ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * SKU ID
     */
    private String skuId;

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