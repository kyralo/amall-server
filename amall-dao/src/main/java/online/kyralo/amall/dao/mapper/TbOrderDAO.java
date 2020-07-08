package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbOrderDO;
import org.springframework.stereotype.Repository;

/**
 * 订单
 */

@Repository
public interface TbOrderDAO extends BaseDao<TbOrderDO> {

    /**
     * 通过ID查询单个订单
     *
     * @param id ID
     * @return {@link TbOrderDO}
     */
    TbOrderDO findById(Integer id);

    /**
     * 分页查询订单
     *
     * @return {@link TbOrderDO}
     */
    Page<TbOrderDO> findByPage();

    /**
     * 新增订单
     *
     * @param tbOrderDO 订单
     * @return 是否新增成功
     */
    @Override
    int insert(TbOrderDO tbOrderDO);

    /**
     * 更新订单
     *
     * @param tbOrderDO 订单
     * @return 是否更新成功
     */
    int update(TbOrderDO tbOrderDO);

    /**
     * 通过ID删除单个订单
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

}