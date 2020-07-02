package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbUserDO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * 用户
 */

@Repository
public interface TbUserDAO extends BaseDao<TbUserDO> {

    /**
     * 通过ID查询单个用户
     *
     * @param id ID
     * @return {@link TbUserDO}
     */
    TbUserDO findById(String id);

    /**
     * 分页查询用户
     *
     * @return {@link TbUserDO}
     */
    Page<TbUserDO> findByPage();

    /**
     * 新增用户
     *
     * @param tbUserDO 用户
     * @return 是否新增成功
     */
    @Override
    int insert(TbUserDO tbUserDO);

    /**
     * 更新用户
     *
     * @param tbUserDO 用户
     * @return 是否更新成功
     */
    int update(TbUserDO tbUserDO);

    /**
     * 通过ID删除单个用户
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}