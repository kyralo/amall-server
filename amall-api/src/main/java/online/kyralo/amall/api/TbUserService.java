package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbUserModel;
import online.kyralo.amall.common.api.Res;

/**
 * 用户
 */
public interface TbUserService {

    /**
     * 通过ID查询单个用户
     *
     * @param id ID
     * @return {@link TbUserModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询用户
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbUserModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增用户
     *
     * @param tbUserModel 用户
     * @return 新增的状态
     */
    Res<?> insert(TbUserModel tbUserModel);

    /**
     * 更新用户
     *
     * @param tbUserModel 用户
     * @return 更新的状态
     */
    Res<?> update(TbUserModel tbUserModel);

    /**
     * 通过ID删除单个用户
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

    /**
     * 通过ID查询单个用户
     *
     * @param id ID
     * @return {@link TbUserModel}
     */
    Res<?> queryById(String id);

}