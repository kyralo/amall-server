package online.kyralo.amall.api;

import online.kyralo.amall.api.model.TbUserCommentModel;
import online.kyralo.amall.common.api.Res;

/**
 * 用户评论
 */
public interface TbUserCommentService {

    /**
     * 通过ID查询单个用户评论
     *
     * @param id ID
     * @return {@link TbUserCommentModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询用户评论
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbUserCommentModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增用户评论
     *
     * @param tbUserCommentModel 用户评论
     * @return 新增的状态
     */
    Res<?> insert(TbUserCommentModel tbUserCommentModel);

    /**
     * 更新用户评论
     *
     * @param tbUserCommentModel 用户评论
     * @return 更新的状态
     */
    Res<?> update(TbUserCommentModel tbUserCommentModel);

    /**
     * 通过ID删除单个用户评论
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}