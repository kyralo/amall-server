package online.kyralo.amall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import online.kyralo.amall.api.TbUserCommentService;
import online.kyralo.amall.api.model.TbUserCommentModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.common.validator.Create;
import online.kyralo.amall.common.validator.Update;
import online.kyralo.amall.web.vo.TbUserCommentVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户评论
 */
@RestController
@RequestMapping("/tbUserComments")
@Api(tags = "用户评论")
@Validated
public class TbUserCommentController {

    @Resource
    private TbUserCommentService tbUserCommentService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID查询单个用户评论", response = TbUserCommentVO.class)
    public Res<?> findById(@ApiParam("ID") @PathVariable("id")
                           @NotNull(message = "id内容不能为空") String id) {
        Res<?> res = tbUserCommentService.findById(id);
        TbUserCommentVO bUserComment = new TbUserCommentVO();
        CopyUtil.copyBean(res.getData(), bUserComment);
        return ResUtil.response(res.getCode(), res.getMessage(), bUserComment);
    }

    @GetMapping
    @ApiOperation(value = "分页查询用户评论", response = TbUserCommentVO.class)
    public Res<?> findByPage(@ApiParam("页号") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @ApiParam("每页大小") @Min(value = 1, message = "正数") @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return tbUserCommentService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation(value = "新增用户评论", response = TbUserCommentVO.class)
    public Res<?> insert(@RequestBody @Validated(Create.class) TbUserCommentModel tbUserComment) {
        return tbUserCommentService.insert(tbUserComment);
    }

    @PutMapping
    @ApiOperation(value = "修改用户评论", response = TbUserCommentVO.class)
    public Res<?> update(@RequestBody @Validated(Update.class) TbUserCommentModel tbUserComment) {
        return tbUserCommentService.update(tbUserComment);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过ID删除单个用户评论", response = TbUserCommentVO.class)
    public Res<?> deleteById(@ApiParam("ID") @PathVariable("id")
                             @NotNull(message = "id内容不能为空") String id) {
        return tbUserCommentService.deleteById(id);
    }
}
