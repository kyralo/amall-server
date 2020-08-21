package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbCommoditySpuService;
import online.kyralo.amall.api.model.TbCommoditySpuModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbCommoditySpuVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import java.util.List;

/**
 * 商品spu表
 */
@RestController
@RequestMapping("/api/v1/commodity_spus")
@Api(tags = "商品spu表")
@Validated
public class TbCommoditySpuController {

    @Resource
    private TbCommoditySpuService tbCommoditySpuService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个商品spu表", response = TbCommoditySpuVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        Res<?> res = tbCommoditySpuService.findById(id);
        TbCommoditySpuVO tbCommoditySpu = new TbCommoditySpuVO();
        CopyUtil.copyBean(res.getData(), tbCommoditySpu);
        return ResUtil.response(res.getCode(), res.getMessage(), tbCommoditySpu);
    }

    @GetMapping
    @ApiOperation(value = "分页查询商品spu表", response = TbCommoditySpuVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        Res<?> res = tbCommoditySpuService.findByPage(pageNum, pageSize);
        List<TbCommoditySpuVO> tbCommoditySpus = CopyUtil.copyList(res.getData(), TbCommoditySpuVO.class);
        return ResUtil.response(res.getCode(), res.getMessage(), tbCommoditySpus);
    }

    @PostMapping
    @ApiOperation(value = "新增商品spu表", response = TbCommoditySpuVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbCommoditySpuModel tbCommoditySpu) {
        return tbCommoditySpuService.insert(tbCommoditySpu);
    }

    @PutMapping
    @ApiOperation(value = "修改商品spu表", response = TbCommoditySpuVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbCommoditySpuModel tbCommoditySpu) {
        return tbCommoditySpuService.update(tbCommoditySpu);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个商品spu表", response = TbCommoditySpuVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbCommoditySpuService.deleteById(id);
    }
}
