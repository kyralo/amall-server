package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbAccountPlatformService;
import online.kyralo.amall.api.model.TbAccountPlatformModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbAccountPlatformVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 第三方用户信息
 */
@RestController
@RequestMapping("/api/v1/account_platforms")
@Api(tags = "第三方用户信息")
@Validated
public class TbAccountPlatformController {

    @Resource
    private TbAccountPlatformService tbAccountPlatformService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个第三方用户信息", response = TbAccountPlatformVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        return tbAccountPlatformService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询第三方用户信息", response = TbAccountPlatformVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbAccountPlatformService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增第三方用户信息", response = TbAccountPlatformVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbAccountPlatformVO tbAccountPlatform) {
        TbAccountPlatformModel tbAccountPlatformModel = new TbAccountPlatformModel();
        BeanUtils.copyProperties(tbAccountPlatform, tbAccountPlatformModel);
        return tbAccountPlatformService.insert(tbAccountPlatformModel);
    }

    @PutMapping
    @ApiOperation(value = "修改第三方用户信息", response = TbAccountPlatformVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbAccountPlatformVO tbAccountPlatform) {
        TbAccountPlatformModel tbAccountPlatformModel = new TbAccountPlatformModel();
        BeanUtils.copyProperties(tbAccountPlatform, tbAccountPlatformModel);
        return tbAccountPlatformService.update(tbAccountPlatformModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个第三方用户信息", response = TbAccountPlatformVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbAccountPlatformService.deleteById(id);
    }
}
