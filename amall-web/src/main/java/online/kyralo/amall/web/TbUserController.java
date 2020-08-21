package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbUserService;
import online.kyralo.amall.api.model.TbUserModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbUserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import java.util.List;

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
        Res<?> res = tbUserService.findById(id);
        TbUserVO tbUser = new TbUserVO();
        CopyUtil.copyBean(res.getData(), tbUser);
        return ResUtil.response(res.getCode(), res.getMessage(), tbUser);
    }

    @GetMapping
    @ApiOperation(value = "分页查询用户", response = TbUserVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        Res<?> res = tbUserService.findByPage(pageNum, pageSize);
        List<TbUserVO> tbUsers = CopyUtil.copyList(res.getData(), TbUserVO.class);
        return ResUtil.response(res.getCode(), res.getMessage(), tbUsers);
    }

    @PostMapping
    @ApiOperation(value = "新增用户", response = TbUserVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbUserModel tbUser) {
        return tbUserService.insert(tbUser);
    }

    @PutMapping
    @ApiOperation(value = "修改用户", response = TbUserVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbUserModel tbUser) {
        return tbUserService.update(tbUser);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个用户", response = TbUserVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbUserService.deleteById(id);
    }
}
