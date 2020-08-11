package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbAccountPlatformDO;
import org.springframework.stereotype.Repository;

/**
 * 第三方用户信息
 */

@Repository
public interface TbAccountPlatformDAO extends BaseDao<TbAccountPlatformDO> {

    /**
     * 通过ID查询单个第三方用户信息
     *
     * @param id ID
     * @return {@link TbAccountPlatformDO}
     */
    TbAccountPlatformDO findById(String id);

    /**
     * 分页查询第三方用户信息
     *
     * @return {@link TbAccountPlatformDO}
     */
    Page<TbAccountPlatformDO> findByPage();

    /**
     * 新增第三方用户信息
     *
     * @param tbAccountPlatformDO 第三方用户信息
     * @return 是否新增成功
     */
    @Override
    int insert(TbAccountPlatformDO tbAccountPlatformDO);

    /**
     * 通过ID删除单个第三方用户信息
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}