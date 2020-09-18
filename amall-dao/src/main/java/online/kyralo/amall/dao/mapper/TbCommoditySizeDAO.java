package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommoditySizeDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * sku表
 */

@Repository
public interface TbCommoditySizeDAO extends BaseDao<TbCommoditySizeDO> {

    /**
     * 通过ID查询单个商品尺寸表
     *
     * @param id ID
     * @return {@link TbCommoditySizeDO}
     */
    TbCommoditySizeDO findById(Integer id);

    /**
     * 分页查询商品尺寸表
     *
     * @return {@link TbCommoditySizeDO}
     */
    Page<TbCommoditySizeDO> findByPage();

    /**
     * 新增商品尺寸表
     *
     * @param tbCommoditySizeDO 商品尺寸表
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommoditySizeDO tbCommoditySizeDO);

    /**
     * 通过ID删除单个商品尺寸表
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

    /**
     * 通过商品 SKU ID 查询所有商品尺寸名
     *
     * @param skuId SKU ID
     * @return {@link List<String>}
     */
    List<String> findSizeNameBySkuId(String skuId);

    /**
     * 通过SKU ID, name 查询单个商品尺寸表
     *
     * @param skuId SKU ID
     * @param name name
     * @return {@link TbCommoditySizeDO}
     */
    TbCommoditySizeDO findBySkuIdAndName(@Param("skuId") String skuId, @Param("name") String name);

}