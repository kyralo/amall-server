package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommodityBrandsModel;
import online.kyralo.amall.common.api.Res;

/**
 * 品牌表
 */
public interface TbCommodityBrandsService {

    /**
     * 通过ID查询单个品牌表
     *
     * @param id ID
     * @return {@link TbCommodityBrandsModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询品牌表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommodityBrandsModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增品牌表
     *
     * @param tbCommodityBrandsModel 品牌表
     * @return 新增的状态
     */
    Res<?> insert(TbCommodityBrandsModel tbCommodityBrandsModel);

    /**
     * 更新品牌表
     *
     * @param tbCommodityBrandsModel 品牌表
     * @return 更新的状态
     */
    Res<?> update(TbCommodityBrandsModel tbCommodityBrandsModel);

    /**
     * 通过ID删除单个品牌表
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}