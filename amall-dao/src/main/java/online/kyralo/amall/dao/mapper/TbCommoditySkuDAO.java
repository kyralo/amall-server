package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommoditySkuDO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * sku表
 */

@Repository
public interface TbCommoditySkuDAO extends BaseDao<TbCommoditySkuDO> {

    /**
     * 通过ID查询单个sku表
     *
     * @param id ID
     * @return {@link TbCommoditySkuDO}
     */
    TbCommoditySkuDO findById(String id);

    /**
     * 分页查询sku表
     *
     * @return {@link TbCommoditySkuDO}
     */
    Page<TbCommoditySkuDO> findByPage();

    /**
     * 新增sku表
     *
     * @param tbCommoditySkuDO sku表
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommoditySkuDO tbCommoditySkuDO);

    /**
     * 更新sku表
     *
     * @param tbCommoditySkuDO sku表
     * @return 是否更新成功
     */
    int update(TbCommoditySkuDO tbCommoditySkuDO);

    /**
     * 通过ID删除单个sku表
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}