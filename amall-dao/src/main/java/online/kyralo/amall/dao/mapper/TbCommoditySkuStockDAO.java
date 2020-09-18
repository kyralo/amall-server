package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbCommoditySkuStockDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * sku库存表
 */

@Repository
public interface TbCommoditySkuStockDAO extends BaseDao<TbCommoditySkuStockDO> {

    /**
     * 通过ID查询单个sku库存表
     *
     * @param id ID
     * @return {@link TbCommoditySkuStockDO}
     */
    TbCommoditySkuStockDO findById(Integer id);

    /**
     * 分页查询sku库存表
     *
     * @return {@link TbCommoditySkuStockDO}
     */
    Page<TbCommoditySkuStockDO> findByPage();

    /**
     * 新增sku库存表
     *
     * @param tbCommoditySkuStockDO sku库存表
     * @return 是否新增成功
     */
    @Override
    int insert(TbCommoditySkuStockDO tbCommoditySkuStockDO);

    /**
     * 通过ID删除单个sku库存表
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

    /**
     * 通过商品 SKU ID 查询商品
     *
     * @param skuId SKU ID
     * @return {@link List <TbCommoditySkuStockDO>}
     */
    List<TbCommoditySkuStockDO> findBySkuId(String skuId);

    /**
     * 通过商品 SKU ID 查询所有商品尺寸名
     *
     * @param skuId SKU ID
     * @return {@link List <String>}
     */
    List<String> findColorNameBySkuId(String skuId);

    /**
     * 通过商品 SKU ID 查询所有商品尺寸名
     *
     * @param skuId SKU ID
     * @param color color
     * @return {@link List <String>}
     */
    List<String> findSizeNameBySkuIdAndColorName(@Param("skuId") String skuId, @Param("color") String color);

    /**
     * 通过商品 SKU ID 查询所有商品尺寸名
     *
     * @param skuId SKU ID
     * @param color color
     * @param sizeName sizeName
     * @return {@link Integer}
     */
    Integer findQuantityBySkuIdAndColorAndSize(@Param("skuId") String skuId, @Param("color") String color, @Param("sizeName") String sizeName);

}