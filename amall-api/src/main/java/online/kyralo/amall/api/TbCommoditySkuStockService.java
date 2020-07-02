package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommoditySkuStockModel;
import online.kyralo.amall.common.api.Res;

/**
 * sku库存表
 */
public interface TbCommoditySkuStockService {

    /**
     * 通过ID查询单个sku库存表
     *
     * @param id ID
     * @return {@link TbCommoditySkuStockModel}
     */
    Res<?> findById(Integer id);

    /**
     * 分页查询sku库存表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommoditySkuStockModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增sku库存表
     *
     * @param tbCommoditySkuStockModel sku库存表
     * @return 新增的状态
     */
    Res<?> insert(TbCommoditySkuStockModel tbCommoditySkuStockModel);

    /**
     * 更新sku库存表
     *
     * @param tbCommoditySkuStockModel sku库存表
     * @return 更新的状态
     */
    Res<?> update(TbCommoditySkuStockModel tbCommoditySkuStockModel);

    /**
     * 通过ID删除单个sku库存表
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(Integer id);

}