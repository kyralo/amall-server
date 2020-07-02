package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommoditySkuService;
import online.kyralo.amall.api.model.TbCommoditySkuModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommoditySkuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * sku表
 */
@RestController
@RequestMapping("/api/v1/commodity_skus")
@Api(tags = "商品sku表")
@Validated
public class TbCommoditySkuController {

    @Resource
    private TbCommoditySkuService tbCommoditySkuService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个sku表", response = TbCommoditySkuVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        return tbCommoditySkuService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询sku表", response = TbCommoditySkuVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbCommoditySkuService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增sku表", response = TbCommoditySkuVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommoditySkuVO tbCommoditySku) {
        TbCommoditySkuModel tbCommoditySkuModel = new TbCommoditySkuModel();
        BeanUtils.copyProperties(tbCommoditySku, tbCommoditySkuModel);
        return tbCommoditySkuService.insert(tbCommoditySkuModel);
    }

    @PutMapping
    @ApiOperation(value = "修改sku表", response = TbCommoditySkuVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommoditySkuVO tbCommoditySku) {
        TbCommoditySkuModel tbCommoditySkuModel = new TbCommoditySkuModel();
        BeanUtils.copyProperties(tbCommoditySku, tbCommoditySkuModel);
        return tbCommoditySkuService.update(tbCommoditySkuModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个sku表", response = TbCommoditySkuVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbCommoditySkuService.deleteById(id);
    }
}
