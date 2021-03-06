package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommodityCategoryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品类型
 */

@Repository
public interface TbCommodityCategoryDAO extends BaseDao<TbCommodityCategoryDO> {

    /**
     * 通过ID查询单个商品类型
     *
     * @param id ID
     * @return {@link TbCommodityCategoryDO}
     */
    TbCommodityCategoryDO findById(Integer id);

    /**
     * 通过name查询单个商品类型
     *
     * @param name name
     * @return {@link TbCommodityCategoryDO}
     */
    TbCommodityCategoryDO findByName(String name);

    /**
     * 分页查询商品类型
     *
     * @return {@link TbCommodityCategoryDO}
     */
    Page<TbCommodityCategoryDO> findByPage();

    /**
     * 新增商品类型
     *
     * @param tbCommodityCategoryDO 商品类型
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommodityCategoryDO tbCommodityCategoryDO);

    /**
     * 通过ID删除单个商品类型
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

    /**
     * 查询商品一级类型
     *
     * @return {@link TbCommodityCategoryDO}
     */
    List<TbCommodityCategoryDO> listPrimaryCategories();

    /**
     * 通过父类型ID查询商品二级类型
     *
     * @param primaryId 一级类型ID
     * @return {@link TbCommodityCategoryDO}
     */
    List<TbCommodityCategoryDO> listSecondCategories(Integer primaryId);

    /**
     * 查询所有一级类型ID
     *
     * @return {@link TbCommodityCategoryDO}
     */
    List<Integer> listPrimaryCategoryIds();

    /**
     * 查询所有二级类型ID 通过一级类型ID
     *
     * @param primaryId 一级类型ID
     * @return {@link TbCommodityCategoryDO}
     */
    List<Integer> listSecondCategoryIdsByPrimaryId(Integer primaryId);

    /**
     * 查询所有二级类型ID 通过一级类型名
     *
     * @param primaryType 一级类型名
     * @return {@link TbCommodityCategoryDO}
     */
    List<Integer> listSecondCategoryIdsByPrimaryType(String primaryType);
}