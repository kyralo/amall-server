package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbMerchantDO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * 商家
 */

@Repository
public interface TbMerchantDAO extends BaseDao<TbMerchantDO> {

    /**
     * 通过ID查询单个商家
     *
     * @param id ID
     * @return {@link TbMerchantDO}
     */
    TbMerchantDO findById(String id);

    /**
     * 分页查询商家
     *
     * @return {@link TbMerchantDO}
     */
    Page<TbMerchantDO> findByPage();

    /**
     * 新增商家
     *
     * @param tbMerchantDO 商家
     * @return 是否新增成功
     */
    @Override
    int insert(TbMerchantDO tbMerchantDO);

    /**
     * 更新商家
     *
     * @param tbMerchantDO 商家
     * @return 是否更新成功
     */
    int update(TbMerchantDO tbMerchantDO);

    /**
     * 通过ID删除单个商家
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}