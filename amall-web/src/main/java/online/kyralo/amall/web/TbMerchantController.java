package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbMerchantService;
import online.kyralo.amall.api.model.TbMerchantModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbMerchantVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import java.util.List;

/**
 * 商家
 */
@RestController
@RequestMapping("/api/v1/merchants")
@Api(tags = "商家")
@Validated
public class TbMerchantController {

    @Resource
    private TbMerchantService tbMerchantService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个商家", response = TbMerchantVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        Res<?> res = tbMerchantService.findById(id);
        TbMerchantVO tbMerchants = new TbMerchantVO();
        CopyUtil.copyBean(res.getData(), tbMerchants);
        return ResUtil.response(res.getCode(), res.getMessage(), tbMerchants);
    }

    @GetMapping
    @ApiOperation(value = "分页查询商家", response = TbMerchantVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        Res<?> res = tbMerchantService.findByPage(pageNum, pageSize);
        List<TbMerchantVO> tbMerchants = CopyUtil.copyList(res.getData(), TbMerchantVO.class);
        return ResUtil.response(res.getCode(), res.getMessage(), tbMerchants);
    }

    @PostMapping
    @ApiOperation(value = "新增商家", response = TbMerchantVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbMerchantModel tbMerchant) {
        return tbMerchantService.insert(tbMerchant);
    }

    @PutMapping
    @ApiOperation(value = "修改商家", response = TbMerchantVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbMerchantModel tbMerchant) {
        return tbMerchantService.update(tbMerchant);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个商家", response = TbMerchantVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbMerchantService.deleteById(id);
    }
}
