package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommodityCategoryModel;
import online.kyralo.amall.common.api.Res;

/**
 * 商品类型
 */
public interface TbCommodityCategoryService {

    /**
     * 通过ID查询单个商品类型
     *
     * @param id ID
     * @return {@link TbCommodityCategoryModel}
     */
    Res<?> findById(Integer id);

    /**
     * 分页查询商品类型
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommodityCategoryModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增商品类型
     *
     * @param tbCommodityCategoryModel 商品类型
     * @return 新增的状态
     */
    Res<?> insert(TbCommodityCategoryModel tbCommodityCategoryModel);

    /**
     * 更新商品类型
     *
     * @param tbCommodityCategoryModel 商品类型
     * @return 更新的状态
     */
    Res<?> update(TbCommodityCategoryModel tbCommodityCategoryModel);

    /**
     * 通过ID删除单个商品类型
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(Integer id);

    /**
     * 查询商品类型 一级类型 + 二级类型
     *
     * @return 商品类型 一级类型 + 二级类型
     */
    Res<?> listCommodityCategories();

}