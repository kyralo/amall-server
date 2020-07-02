package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommoditySkuModel;
import online.kyralo.amall.common.api.Res;

/**
 * sku表
 */
public interface TbCommoditySkuService {

    /**
     * 通过ID查询单个sku表
     *
     * @param id ID
     * @return {@link TbCommoditySkuModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询sku表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommoditySkuModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增sku表
     *
     * @param tbCommoditySkuModel sku表
     * @return 新增的状态
     */
    Res<?> insert(TbCommoditySkuModel tbCommoditySkuModel);

    /**
     * 更新sku表
     *
     * @param tbCommoditySkuModel sku表
     * @return 更新的状态
     */
    Res<?> update(TbCommoditySkuModel tbCommoditySkuModel);

    /**
     * 通过ID删除单个sku表
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}