package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommoditySkuStockService;
import online.kyralo.amall.api.model.TbCommoditySkuStockModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommoditySkuStockVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * sku库存表
 */
@RestController
@RequestMapping("/api/v1/commodity_sku_stocks")
@Api(tags = "商品库存表")
@Validated
public class TbCommoditySkuStockController {

    @Resource
    private TbCommoditySkuStockService tbCommoditySkuStockService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个sku库存表", response = TbCommoditySkuStockVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") Integer id) {
        return tbCommoditySkuStockService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询sku库存表", response = TbCommoditySkuStockVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbCommoditySkuStockService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增sku库存表", response = TbCommoditySkuStockVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommoditySkuStockVO tbCommoditySkuStock) {
        TbCommoditySkuStockModel tbCommoditySkuStockModel = new TbCommoditySkuStockModel();
        BeanUtils.copyProperties(tbCommoditySkuStock, tbCommoditySkuStockModel);
        return tbCommoditySkuStockService.insert(tbCommoditySkuStockModel);
    }

    @PutMapping
    @ApiOperation(value = "修改sku库存表", response = TbCommoditySkuStockVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommoditySkuStockVO tbCommoditySkuStock) {
        TbCommoditySkuStockModel tbCommoditySkuStockModel = new TbCommoditySkuStockModel();
        BeanUtils.copyProperties(tbCommoditySkuStock, tbCommoditySkuStockModel);
        return tbCommoditySkuStockService.update(tbCommoditySkuStockModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个sku库存表", response = TbCommoditySkuStockVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") Integer id) {
        return tbCommoditySkuStockService.deleteById(id);
    }
}
