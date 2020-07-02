package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbUserService;
import online.kyralo.amall.api.model.TbUserModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 用户
 */
@RestController
@RequestMapping("/api/v1/users")
@Api(tags = "用户")
@Validated
public class TbUserController {

    @Resource
    private TbUserService tbUserService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个用户", response = TbUserVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        return tbUserService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询用户", response = TbUserVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbUserService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增用户", response = TbUserVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbUserVO tbUser) {
        TbUserModel tbUserModel = new TbUserModel();
        BeanUtils.copyProperties(tbUser, tbUserModel);
        return tbUserService.insert(tbUserModel);
    }

    @PutMapping
    @ApiOperation(value = "修改用户", response = TbUserVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbUserVO tbUser) {
        TbUserModel tbUserModel = new TbUserModel();
        BeanUtils.copyProperties(tbUser, tbUserModel);
        return tbUserService.update(tbUserModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个用户", response = TbUserVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbUserService.deleteById(id);
    }
}
