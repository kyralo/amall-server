package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommoditySizeService;
import online.kyralo.amall.api.model.TbCommoditySizeModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommoditySizeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * sku表
 */
@RestController
@RequestMapping("/api/v1/commodity_sizes")
@Api(tags = "商品尺寸表")
@Validated
public class TbCommoditySizeController {

    @Resource
    private TbCommoditySizeService tbCommoditySizeService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个sku表", response = TbCommoditySizeVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") Integer id) {
        return tbCommoditySizeService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询sku表", response = TbCommoditySizeVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbCommoditySizeService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增sku表", response = TbCommoditySizeVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommoditySizeVO tbCommoditySize) {
        TbCommoditySizeModel tbCommoditySizeModel = new TbCommoditySizeModel();
        BeanUtils.copyProperties(tbCommoditySize, tbCommoditySizeModel);
        return tbCommoditySizeService.insert(tbCommoditySizeModel);
    }

    @PutMapping
    @ApiOperation(value = "修改sku表", response = TbCommoditySizeVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommoditySizeVO tbCommoditySize) {
        TbCommoditySizeModel tbCommoditySizeModel = new TbCommoditySizeModel();
        BeanUtils.copyProperties(tbCommoditySize, tbCommoditySizeModel);
        return tbCommoditySizeService.update(tbCommoditySizeModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个sku表", response = TbCommoditySizeVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") Integer id) {
        return tbCommoditySizeService.deleteById(id);
    }
}
