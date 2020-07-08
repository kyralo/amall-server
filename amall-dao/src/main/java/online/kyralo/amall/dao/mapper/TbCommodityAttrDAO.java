package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommodityAttrDO;
import org.springframework.stereotype.Repository;

/**
 * 销售属性表 (产品参数)
 */

@Repository
public interface TbCommodityAttrDAO extends BaseDao<TbCommodityAttrDO> {

    /**
     * 通过ID查询单个销售属性表 (产品参数)
     *
     * @param id ID
     * @return {@link TbCommodityAttrDO}
     */
    TbCommodityAttrDO findById(String id);

    /**
     * 分页查询销售属性表 (产品参数)
     *
     * @return {@link TbCommodityAttrDO}
     */
    Page<TbCommodityAttrDO> findByPage();

    /**
     * 新增销售属性表 (产品参数)
     *
     * @param tbCommodityAttrDO 销售属性表 (产品参数)
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommodityAttrDO tbCommodityAttrDO);

    /**
     * 更新销售属性表 (产品参数)
     *
     * @param tbCommodityAttrDO 销售属性表 (产品参数)
     * @return 是否更新成功
     */
    int update(TbCommodityAttrDO tbCommodityAttrDO);

    /**
     * 通过ID删除单个销售属性表 (产品参数)
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}