package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbAccountPlatformModel;
import online.kyralo.amall.common.api.Res;

/**
 * 第三方用户信息
 */
public interface TbAccountPlatformService {

    /**
     * 通过ID查询单个第三方用户信息
     *
     * @param id ID
     * @return {@link TbAccountPlatformModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询第三方用户信息
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbAccountPlatformModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增第三方用户信息
     *
     * @param tbAccountPlatformModel 第三方用户信息
     * @return 新增的状态
     */
    Res<?> insert(TbAccountPlatformModel tbAccountPlatformModel);

    /**
     * 更新第三方用户信息
     *
     * @param tbAccountPlatformModel 第三方用户信息
     * @return 更新的状态
     */
    Res<?> update(TbAccountPlatformModel tbAccountPlatformModel);

    /**
     * 通过ID删除单个第三方用户信息
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}