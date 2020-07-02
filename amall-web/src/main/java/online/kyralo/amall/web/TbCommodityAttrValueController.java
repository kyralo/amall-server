package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommodityAttrValueService;
import online.kyralo.amall.api.model.TbCommodityAttrValueModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommodityAttrValueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 销售属性值
 */
@RestController
@RequestMapping("/api/v1/commodity_attr_values")
@Api(tags = "销售属性值")
@Validated
public class TbCommodityAttrValueController {

    @Resource
    private TbCommodityAttrValueService tbCommodityAttrValueService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个销售属性值", response = TbCommodityAttrValueVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        return tbCommodityAttrValueService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询销售属性值", response = TbCommodityAttrValueVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbCommodityAttrValueService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增销售属性值", response = TbCommodityAttrValueVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommodityAttrValueVO tbCommodityAttrValue) {
        TbCommodityAttrValueModel tbCommodityAttrValueModel = new TbCommodityAttrValueModel();
        BeanUtils.copyProperties(tbCommodityAttrValue, tbCommodityAttrValueModel);
        return tbCommodityAttrValueService.insert(tbCommodityAttrValueModel);
    }

    @PutMapping
    @ApiOperation(value = "修改销售属性值", response = TbCommodityAttrValueVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommodityAttrValueVO tbCommodityAttrValue) {
        TbCommodityAttrValueModel tbCommodityAttrValueModel = new TbCommodityAttrValueModel();
        BeanUtils.copyProperties(tbCommodityAttrValue, tbCommodityAttrValueModel);
        return tbCommodityAttrValueService.update(tbCommodityAttrValueModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个销售属性值", response = TbCommodityAttrValueVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbCommodityAttrValueService.deleteById(id);
    }
}
