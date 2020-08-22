package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbUserCollectionModel;
import online.kyralo.amall.common.api.Res;

/**
 * 用户收藏
 */
public interface TbUserCollectionService {

    /**
     * 通过ID查询单个用户收藏
     *
     * @param id ID
     * @return {@link TbUserCollectionModel}
     */
    Res<?> findById(Integer id);

    /**
     * 分页查询用户收藏
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbUserCollectionModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增用户收藏
     *
     * @param tbUserCollectionModel 用户收藏
     * @return 新增的状态
     */
    Res<?> insert(TbUserCollectionModel tbUserCollectionModel);

    /**
     * 更新用户收藏
     *
     * @param tbUserCollectionModel 用户收藏
     * @return 更新的状态
     */
    Res<?> update(TbUserCollectionModel tbUserCollectionModel);

    /**
     * 通过ID删除单个用户收藏
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(Integer id);

    /**
     * 统计收藏
     *
     * @param userId 用户ID
     * @return 统计数
     */
    Res<?> countByUserId(String userId);

}