package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.web.vo.TbUserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/19
 * \* Time: 22:04
 * \* Description: 登录
 * \
 */

@RestController
@RequestMapping("/api/v1/login")
@Api(tags = "登录")
@Validated
public class LoginController {

    @PostMapping("/pc/user")
    @ApiOperation(value = "PC端 用户登录", response = TbUserVO.class)
    public Res<?> userLogin(@RequestParam String username,
                            @RequestParam String password) {

        return null;
    }

}
