package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommodityBrandsDO;
import org.springframework.stereotype.Repository;

/**
 * 品牌表
 */

@Repository
public interface TbCommodityBrandsDAO extends BaseDao<TbCommodityBrandsDO> {

    /**
     * 通过ID查询单个品牌表
     *
     * @param id ID
     * @return {@link TbCommodityBrandsDO}
     */
    TbCommodityBrandsDO findById(String id);

    /**
     * 分页查询品牌表
     *
     * @return {@link TbCommodityBrandsDO}
     */
    Page<TbCommodityBrandsDO> findByPage();

    /**
     * 新增品牌表
     *
     * @param tbCommodityBrandsDO 品牌表
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommodityBrandsDO tbCommodityBrandsDO);

    /**
     * 更新品牌表
     *
     * @param tbCommodityBrandsDO 品牌表
     * @return 是否更新成功
     */
    int update(TbCommodityBrandsDO tbCommodityBrandsDO);

    /**
     * 通过ID删除单个品牌表
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}