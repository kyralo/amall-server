package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommoditySizeModel;
import online.kyralo.amall.common.api.Res;

/**
 * sku表
 */
public interface TbCommoditySizeService {

    /**
     * 通过ID查询单个sku表
     *
     * @param id ID
     * @return {@link TbCommoditySizeModel}
     */
    Res<?> findById(Integer id);

    /**
     * 分页查询sku表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommoditySizeModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增sku表
     *
     * @param tbCommoditySizeModel sku表
     * @return 新增的状态
     */
    Res<?> insert(TbCommoditySizeModel tbCommoditySizeModel);

    /**
     * 更新sku表
     *
     * @param tbCommoditySizeModel sku表
     * @return 更新的状态
     */
    Res<?> update(TbCommoditySizeModel tbCommoditySizeModel);

    /**
     * 通过ID删除单个sku表
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(Integer id);

}