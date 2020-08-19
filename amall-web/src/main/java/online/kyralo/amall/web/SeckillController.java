package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.web.vo.PSeckillVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static online.kyralo.amall.common.constants.SecurityConstant.HEADER_STRING;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/18
 * \* Time: 23:55
 * \* Description: PC端页面 秒杀
 * \
 */
@RestController
@RequestMapping("/api/v1/seckill")
@Api(tags = "PC端页面 秒杀")
@Validated
public class SeckillController {

    @GetMapping
    @ApiOperation(value = "查询 秒杀页 信息", response = PSeckillVO.class)
    public Res<?> getPageInfo(@RequestHeader(HEADER_STRING) String token) {

        return null;
    }
}