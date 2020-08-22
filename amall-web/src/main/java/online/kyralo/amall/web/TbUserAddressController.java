package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbUserAddressService;
import online.kyralo.amall.api.model.TbUserAddressModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbUserAddressVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 用户地址
 */
@RestController
@RequestMapping("/api/v1/user_addresss")
@Api(tags = "用户地址")
@Validated
public class TbUserAddressController {

    @Resource
    private TbUserAddressService tbUserAddressService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个用户地址", response = TbUserAddressVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") Integer id) {
        Res<?> res = tbUserAddressService.findById(id);
        TbUserAddressVO tbUserAddress = new TbUserAddressVO();
        CopyUtil.copyBean(res.getData(), tbUserAddress);
        return ResUtil.response(res.getCode(), res.getMessage(), tbUserAddress);
    }

    @GetMapping
    @ApiOperation(value = "分页查询用户地址", response = TbUserAddressVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbUserAddressService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增用户地址", response = TbUserAddressVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbUserAddressModel tbUserAddress) {
        return tbUserAddressService.insert(tbUserAddress);
    }

    @PutMapping
    @ApiOperation(value = "修改用户地址", response = TbUserAddressVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbUserAddressModel tbUserAddress) {
        return tbUserAddressService.update(tbUserAddress);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个用户地址", response = TbUserAddressVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") Integer id) {
        return tbUserAddressService.deleteById(id);
    }
}
