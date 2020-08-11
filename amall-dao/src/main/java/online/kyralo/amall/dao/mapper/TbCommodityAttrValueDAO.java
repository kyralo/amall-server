package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommodityAttrValueDO;
import org.springframework.stereotype.Repository;

/**
 * 销售属性值
 */

@Repository
public interface TbCommodityAttrValueDAO extends BaseDao<TbCommodityAttrValueDO> {

    /**
     * 通过ID查询单个销售属性值
     *
     * @param id ID
     * @return {@link TbCommodityAttrValueDO}
     */
    TbCommodityAttrValueDO findById(String id);

    /**
     * 分页查询销售属性值
     *
     * @return {@link TbCommodityAttrValueDO}
     */
    Page<TbCommodityAttrValueDO> findByPage();

    /**
     * 新增销售属性值
     *
     * @param tbCommodityAttrValueDO 销售属性值
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommodityAttrValueDO tbCommodityAttrValueDO);

    /**
     * 通过ID删除单个销售属性值
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}