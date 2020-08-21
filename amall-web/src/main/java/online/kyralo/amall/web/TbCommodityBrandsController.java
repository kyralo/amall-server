package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommodityBrandsService;
import online.kyralo.amall.api.model.TbCommodityBrandsModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommodityBrandsVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import java.util.List;

/**
 * 品牌表
 */
@RestController
@RequestMapping("/api/v1/commodity_brands")
@Api(tags = "品牌表")
@Validated
public class TbCommodityBrandsController {

    @Resource
    private TbCommodityBrandsService tbCommodityBrandsService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个品牌表", response = TbCommodityBrandsVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        Res<?> res = tbCommodityBrandsService.findById(id);
        TbCommodityBrandsVO tbCommodityBrand = new TbCommodityBrandsVO();
        CopyUtil.copyBean(res.getData(), tbCommodityBrand);
        return ResUtil.response(res.getCode(), res.getMessage(), tbCommodityBrand);
    }

    @GetMapping
    @ApiOperation(value = "分页查询品牌表", response = TbCommodityBrandsVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        Res<?> res = tbCommodityBrandsService.findByPage(pageNum, pageSize);
        List<TbCommodityBrandsVO> tbCommodityBrands = CopyUtil.copyList(res.getData(), TbCommodityBrandsVO.class);
        return ResUtil.response(res.getCode(), res.getMessage(), tbCommodityBrands);
    }

    @PostMapping
    @ApiOperation(value = "新增品牌表", response = TbCommodityBrandsVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommodityBrandsModel tbCommodityBrands) {
        return tbCommodityBrandsService.insert(tbCommodityBrands);
    }

    @PutMapping
    @ApiOperation(value = "修改品牌表", response = TbCommodityBrandsVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommodityBrandsModel tbCommodityBrands) {
        return tbCommodityBrandsService.update(tbCommodityBrands);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个品牌表", response = TbCommodityBrandsVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbCommodityBrandsService.deleteById(id);
    }
}
