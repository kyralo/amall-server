package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommodityAttrService;
import online.kyralo.amall.api.model.TbCommodityAttrModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommodityAttrVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 销售属性表 (产品参数)
 */
@RestController
@RequestMapping("/api/v1/commodity_attrs")
@Api(tags = "销售属性表 (产品参数)")
@Validated
public class TbCommodityAttrController {

    @Resource
    private TbCommodityAttrService tbCommodityAttrService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个销售属性表 (产品参数)", response = TbCommodityAttrVO.class)
    public Res<?> findById(@ApiParam("id") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        Res<?> res = tbCommodityAttrService.findById(id);
        TbCommodityAttrVO tbCommodityAttr = new TbCommodityAttrVO();
        CopyUtil.copyBean(res.getData(), tbCommodityAttr);
        return ResUtil.response(res.getCode(), res.getMessage(), tbCommodityAttr);
    }

    @GetMapping
    @ApiOperation(value = "分页查询销售属性表 (产品参数)", response = TbCommodityAttrVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbCommodityAttrService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增销售属性表 (产品参数)", response = TbCommodityAttrVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommodityAttrModel tbCommodityAttr) {
        return tbCommodityAttrService.insert(tbCommodityAttr);
    }

    @PutMapping
    @ApiOperation(value = "修改销售属性表 (产品参数)", response = TbCommodityAttrVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommodityAttrModel tbCommodityAttr) {
        return tbCommodityAttrService.update(tbCommodityAttr);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个销售属性表 (产品参数)", response = TbCommodityAttrVO.class)
    public Res<?> deleteById(@ApiParam("id") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbCommodityAttrService.deleteById(id);
    }
}
