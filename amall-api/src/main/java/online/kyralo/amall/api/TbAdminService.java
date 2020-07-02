package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbAdminModel;
import online.kyralo.amall.common.api.Res;

/**
 * 管理员
 */
public interface TbAdminService {

    /**
     * 通过ID查询单个管理员
     *
     * @param id ID
     * @return {@link TbAdminModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询管理员
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbAdminModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增管理员
     *
     * @param tbAdminModel 管理员
     * @return 新增的状态
     */
    Res<?> insert(TbAdminModel tbAdminModel);

    /**
     * 更新管理员
     *
     * @param tbAdminModel 管理员
     * @return 更新的状态
     */
    Res<?> update(TbAdminModel tbAdminModel);

    /**
     * 通过ID删除单个管理员
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}