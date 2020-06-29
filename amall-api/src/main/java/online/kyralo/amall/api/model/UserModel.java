package online.kyralo.amall.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangchen
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Integer id;

    private String name;

    private Integer age;

}