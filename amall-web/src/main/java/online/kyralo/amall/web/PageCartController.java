package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.CartService;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.JwtUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.web.vo.PCartVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

import java.util.List;

import static online.kyralo.amall.common.constants.SecurityConstant.HEADER_STRING;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/18
 * \* Time: 23:54
 * \* Description: PC端页面 购物车
 * \
 */
@RestController
@RequestMapping("/api/v1/cart")
@Api(tags = "PC端页面 购物车")
@Validated
public class PageCartController {

    @Resource
    private CartService cartService;

    @GetMapping
    @ApiOperation(value = "查询 购物车页 信息", response = PCartVO.class)
    public Res<?> getPageInfo(@RequestHeader(HEADER_STRING) String token,
                              @ApiParam("页号") @Min(value = 0, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                              @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {

        String userId = JwtUtil.getUserNameFromToken(token);

        if (userId == null) {
            return ResUtil.error();
        }

        PCartVO cart = new PCartVO();

        Object cartsBO = cartService.listCartByUserId(userId, pageNum, pageSize).getData();
        List<PCartVO.CartItem> cartItems = CopyUtil.copyList(cartsBO, PCartVO.CartItem.class);
        cart.setCartItems(cartItems);

        return ResUtil.success(cart);
    }
}
