package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommoditySkuStockDO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * sku库存表
 */

@Repository
public interface TbCommoditySkuStockDAO extends BaseDao<TbCommoditySkuStockDO> {

    /**
     * 通过ID查询单个sku库存表
     *
     * @param id ID
     * @return {@link TbCommoditySkuStockDO}
     */
    TbCommoditySkuStockDO findById(Integer id);

    /**
     * 分页查询sku库存表
     *
     * @return {@link TbCommoditySkuStockDO}
     */
    Page<TbCommoditySkuStockDO> findByPage();

    /**
     * 新增sku库存表
     *
     * @param tbCommoditySkuStockDO sku库存表
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommoditySkuStockDO tbCommoditySkuStockDO);

    /**
     * 更新sku库存表
     *
     * @param tbCommoditySkuStockDO sku库存表
     * @return 是否更新成功
     */
    int update(TbCommoditySkuStockDO tbCommoditySkuStockDO);

    /**
     * 通过ID删除单个sku库存表
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

}