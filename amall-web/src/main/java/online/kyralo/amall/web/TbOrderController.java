package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbOrderService;
import online.kyralo.amall.api.model.TbOrderModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbOrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

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
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") Integer id) {
        return tbOrderService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询订单", response = TbOrderVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbOrderService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增订单", response = TbOrderVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbOrderVO tbOrder) {
        TbOrderModel tbOrderModel = new TbOrderModel();
        BeanUtils.copyProperties(tbOrder, tbOrderModel);
        return tbOrderService.insert(tbOrderModel);
    }

    @PutMapping
    @ApiOperation(value = "修改订单", response = TbOrderVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbOrderVO tbOrder) {
        TbOrderModel tbOrderModel = new TbOrderModel();
        BeanUtils.copyProperties(tbOrder, tbOrderModel);
        return tbOrderService.update(tbOrderModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个订单", response = TbOrderVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") Integer id) {
        return tbOrderService.deleteById(id);
    }
}
