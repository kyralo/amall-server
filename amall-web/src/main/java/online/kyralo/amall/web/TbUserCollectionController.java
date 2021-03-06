package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbUserCollectionService;
import online.kyralo.amall.api.model.TbUserCollectionModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbUserCollectionVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.*;

/**
 * 用户收藏
 */
@RestController
@RequestMapping("/api/v1/user_collections")
@Api(tags = "用户收藏")
@Validated
public class TbUserCollectionController {

    @Resource
    private TbUserCollectionService tbUserCollectionService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个用户收藏", response = TbUserCollectionVO.class)
    public Res<?> findById(@ApiParam("id") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") Integer id) {
        Res<?> res = tbUserCollectionService.findById(id);
        TbUserCollectionVO tbUserCollection = new TbUserCollectionVO();
        CopyUtil.copyBean(res.getData(), tbUserCollection);
        return ResUtil.response(res.getCode(), res.getMessage(), tbUserCollection);
    }

    @GetMapping
    @ApiOperation(value = "分页查询用户收藏", response = TbUserCollectionVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbUserCollectionService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增用户收藏", response = TbUserCollectionVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbUserCollectionModel tbUserCollection) {
        return tbUserCollectionService.insert(tbUserCollection);
    }

    @PutMapping
    @ApiOperation(value = "修改用户收藏", response = TbUserCollectionVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbUserCollectionModel tbUserCollection) {
        return tbUserCollectionService.update(tbUserCollection);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个用户收藏", response = TbUserCollectionVO.class)
    public Res<?> deleteById(@ApiParam("id") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") Integer id) {
        return tbUserCollectionService.deleteById(id);
    }
}
