package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbOrderService;
import online.kyralo.amall.api.model.TbOrderModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.POrderVO;
import online.kyralo.amall.web.vo.TbOrderVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

import static online.kyralo.amall.common.constants.SecurityConstant.HEADER_STRING;

/**
 * 订单
 */
@RestController
@RequestMapping("/api/v1/orders")
@Api(tags = "订单")
@Validated
public class TbOrderController {

    @Resource
    private TbOrderService tbOrderService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个订单", response = TbOrderVO.class)
    public Res<?> findById(@ApiParam("id") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") Integer id) {
        Res<?> res = tbOrderService.findById(id);
        TbOrderVO tbOrder = new TbOrderVO();
        CopyUtil.copyBean(res.getData(), tbOrder);
        return ResUtil.response(res.getCode(), res.getMessage(), tbOrder);
    }

    @GetMapping
    @ApiOperation(value = "分页查询订单", response = TbOrderVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbOrderService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增订单", response = TbOrderVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbOrderModel tbOrder) {
        return tbOrderService.insert(tbOrder);
    }

    @PutMapping
    @ApiOperation(value = "修改订单", response = TbOrderVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbOrderModel tbOrder) {
        return tbOrderService.update(tbOrder);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个订单", response = TbOrderVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") Integer id) {
        return tbOrderService.deleteById(id);
    }

    @GetMapping("/paid")
    @ApiOperation(value = "通过用户ID查询 已付款订单", response = POrderVO.class)
    public Res<?> listPaidOrdersByUserId(@RequestHeader(value = HEADER_STRING) String token) {
        return null;
    }

    @GetMapping("/user")
    @ApiOperation(value = "通过用户ID查询单个订单", response = TbOrderVO.class)
    public Res<?> getPagePayOrderInfoById(
            @ApiParam("订单id") @RequestParam("userId") @NotNull(message = "id内容不能为空") Integer id,
            @RequestHeader(value = HEADER_STRING) String token) {
        Res<?> res = tbOrderService.findById(id);
        TbOrderVO tbOrder = new TbOrderVO();
        CopyUtil.copyBean(res.getData(), tbOrder);
        return ResUtil.response(res.getCode(), res.getMessage(), tbOrder);
    }
}
