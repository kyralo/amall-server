package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbUserAddressDO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * 用户地址
 */

@Repository
public interface TbUserAddressDAO extends BaseDao<TbUserAddressDO> {

    /**
     * 通过ID查询单个用户地址
     *
     * @param id ID
     * @return {@link TbUserAddressDO}
     */
    TbUserAddressDO findById(Integer id);

    /**
     * 分页查询用户地址
     *
     * @return {@link TbUserAddressDO}
     */
    Page<TbUserAddressDO> findByPage();

    /**
     * 新增用户地址
     *
     * @param tbUserAddressDO 用户地址
     * @return 是否新增成功
     */
    @Override
    int insert(TbUserAddressDO tbUserAddressDO);

    /**
     * 更新用户地址
     *
     * @param tbUserAddressDO 用户地址
     * @return 是否更新成功
     */
    int update(TbUserAddressDO tbUserAddressDO);

    /**
     * 通过ID删除单个用户地址
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

}