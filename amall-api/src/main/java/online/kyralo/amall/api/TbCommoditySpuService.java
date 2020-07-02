package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommoditySpuModel;
import online.kyralo.amall.common.api.Res;

/**
 * 商品spu表
 */
public interface TbCommoditySpuService {

    /**
     * 通过ID查询单个商品spu表
     *
     * @param id ID
     * @return {@link TbCommoditySpuModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询商品spu表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommoditySpuModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增商品spu表
     *
     * @param tbCommoditySpuModel 商品spu表
     * @return 新增的状态
     */
    Res<?> insert(TbCommoditySpuModel tbCommoditySpuModel);

    /**
     * 更新商品spu表
     *
     * @param tbCommoditySpuModel 商品spu表
     * @return 更新的状态
     */
    Res<?> update(TbCommoditySpuModel tbCommoditySpuModel);

    /**
     * 通过ID删除单个商品spu表
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}