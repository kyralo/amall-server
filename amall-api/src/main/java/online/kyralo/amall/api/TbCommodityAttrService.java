package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbCommodityAttrModel;
import online.kyralo.amall.common.api.Res;

/**
 * 销售属性表 (产品参数)
 */
public interface TbCommodityAttrService {

    /**
     * 通过ID查询单个销售属性表 (产品参数)
     *
     * @param id ID
     * @return {@link TbCommodityAttrModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询销售属性表 (产品参数)
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbCommodityAttrModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增销售属性表 (产品参数)
     *
     * @param tbCommodityAttrModel 销售属性表 (产品参数)
     * @return 新增的状态
     */
    Res<?> insert(TbCommodityAttrModel tbCommodityAttrModel);

    /**
     * 更新销售属性表 (产品参数)
     *
     * @param tbCommodityAttrModel 销售属性表 (产品参数)
     * @return 更新的状态
     */
    Res<?> update(TbCommodityAttrModel tbCommodityAttrModel);

    /**
     * 通过ID删除单个销售属性表 (产品参数)
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}