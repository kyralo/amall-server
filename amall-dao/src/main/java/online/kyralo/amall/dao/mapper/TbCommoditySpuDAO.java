package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommoditySpuDO;
import org.springframework.stereotype.Repository;

/**
 * 商品spu表
 */

@Repository
public interface TbCommoditySpuDAO extends BaseDao<TbCommoditySpuDO> {

    /**
     * 通过ID查询单个商品spu表
     *
     * @param id ID
     * @return {@link TbCommoditySpuDO}
     */
    TbCommoditySpuDO findById(String id);

    /**
     * 分页查询商品spu表
     *
     * @return {@link TbCommoditySpuDO}
     */
    Page<TbCommoditySpuDO> findByPage();

    /**
     * 新增商品spu表
     *
     * @param tbCommoditySpuDO 商品spu表
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommoditySpuDO tbCommoditySpuDO);

    /**
     * 更新商品spu表
     *
     * @param tbCommoditySpuDO 商品spu表
     * @return 是否更新成功
     */
    int update(TbCommoditySpuDO tbCommoditySpuDO);

    /**
     * 通过ID删除单个商品spu表
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}