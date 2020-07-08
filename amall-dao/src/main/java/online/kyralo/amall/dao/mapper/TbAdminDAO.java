package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbAdminDO;
import org.springframework.stereotype.Repository;

/**
 * 管理员
 */

@Repository
public interface TbAdminDAO extends BaseDao<TbAdminDO> {

    /**
     * 通过ID查询单个管理员
     *
     * @param id ID
     * @return {@link TbAdminDO}
     */
    TbAdminDO findById(String id);

    /**
     * 分页查询管理员
     *
     * @return {@link TbAdminDO}
     */
    Page<TbAdminDO> findByPage();

    /**
     * 新增管理员
     *
     * @param tbAdminDO 管理员
     * @return 是否新增成功
     */
    @Override
    int insert(TbAdminDO tbAdminDO);

    /**
     * 更新管理员
     *
     * @param tbAdminDO 管理员
     * @return 是否更新成功
     */
    int update(TbAdminDO tbAdminDO);

    /**
     * 通过ID删除单个管理员
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}