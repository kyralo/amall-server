package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommodityCategoryService;
import online.kyralo.amall.api.model.TbCommodityCategoryModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommodityCategoryVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 商品类型
 */
@RestController
@RequestMapping("/commodity_categorys")
@Api(tags = "商品类型")
@Validated
public class TbCommodityCategoryController {

    @Resource
    private TbCommodityCategoryService tbCommodityCategoryService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个商品类型", response = TbCommodityCategoryVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") Integer id) {
        Res<?> res = tbCommodityCategoryService.findById(id);
        TbCommodityCategoryVO bCommodityCategory = new TbCommodityCategoryVO();
        CopyUtil.copyBean(res.getData(), bCommodityCategory);
        return ResUtil.response(res.getCode(), res.getMessage(), bCommodityCategory);
    }

    @GetMapping
    @ApiOperation(value = "分页查询商品类型", response = TbCommodityCategoryVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbCommodityCategoryService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增商品类型", response = TbCommodityCategoryVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommodityCategoryModel tbCommodityCategory) {
        return tbCommodityCategoryService.insert(tbCommodityCategory);
    }

    @PutMapping
    @ApiOperation(value = "修改商品类型", response = TbCommodityCategoryVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommodityCategoryModel tbCommodityCategory) {
        return tbCommodityCategoryService.update(tbCommodityCategory);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个商品类型", response = TbCommodityCategoryVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") Integer id) {
        return tbCommodityCategoryService.deleteById(id);
    }
}
