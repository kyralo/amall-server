package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbAdminService;
import online.kyralo.amall.api.model.TbAdminModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbAdminVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 管理员
 */
@RestController
@RequestMapping("/api/v1/admins")
@Api(tags = "管理员")
@Validated
public class TbAdminController {

    @Resource
    private TbAdminService tbAdminService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个管理员", response = TbAdminVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        Res<?> res = tbAdminService.findById(id);
        TbAdminVO tbAdmin = new TbAdminVO();
        CopyUtil.copyBean(res.getData(), tbAdmin);
        return ResUtil.response(res.getCode(), res.getMessage(), tbAdmin);
    }

    @GetMapping
    @ApiOperation(value = "分页查询管理员", response = TbAdminVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbAdminService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增管理员", response = TbAdminVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbAdminModel tbAdmin) {
        return tbAdminService.insert(tbAdmin);
    }

    @PutMapping
    @ApiOperation(value = "修改管理员", response = TbAdminVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbAdminModel tbAdmin) {
        return tbAdminService.update(tbAdmin);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个管理员", response = TbAdminVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbAdminService.deleteById(id);
    }
}
