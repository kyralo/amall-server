package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommoditySizeDO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * sku表
 */

@Repository
public interface TbCommoditySizeDAO extends BaseDao<TbCommoditySizeDO> {

    /**
     * 通过ID查询单个sku表
     *
     * @param id ID
     * @return {@link TbCommoditySizeDO}
     */
    TbCommoditySizeDO findById(Integer id);

    /**
     * 分页查询sku表
     *
     * @return {@link TbCommoditySizeDO}
     */
    Page<TbCommoditySizeDO> findByPage();

    /**
     * 新增sku表
     *
     * @param tbCommoditySizeDO sku表
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommoditySizeDO tbCommoditySizeDO);

    /**
     * 更新sku表
     *
     * @param tbCommoditySizeDO sku表
     * @return 是否更新成功
     */
    int update(TbCommoditySizeDO tbCommoditySizeDO);

    /**
     * 通过ID删除单个sku表
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

}