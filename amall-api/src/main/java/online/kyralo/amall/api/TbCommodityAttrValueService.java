package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommodityAttrValueModel;
import online.kyralo.amall.common.api.Res;

/**
 * 销售属性值
 */
public interface TbCommodityAttrValueService {

    /**
     * 通过ID查询单个销售属性值
     *
     * @param id ID
     * @return {@link TbCommodityAttrValueModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询销售属性值
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommodityAttrValueModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增销售属性值
     *
     * @param tbCommodityAttrValueModel 销售属性值
     * @return 新增的状态
     */
    Res<?> insert(TbCommodityAttrValueModel tbCommodityAttrValueModel);

    /**
     * 更新销售属性值
     *
     * @param tbCommodityAttrValueModel 销售属性值
     * @return 更新的状态
     */
    Res<?> update(TbCommodityAttrValueModel tbCommodityAttrValueModel);

    /**
     * 通过ID删除单个销售属性值
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}