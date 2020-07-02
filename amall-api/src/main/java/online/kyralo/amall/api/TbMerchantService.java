package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbMerchantModel;
import online.kyralo.amall.common.api.Res;

/**
 * 商家
 */
public interface TbMerchantService {

    /**
     * 通过ID查询单个商家
     *
     * @param id ID
     * @return {@link TbMerchantModel}
     */
    Res<?> findById(String id);

    /**
     * 分页查询商家
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbMerchantModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增商家
     *
     * @param tbMerchantModel 商家
     * @return 新增的状态
     */
    Res<?> insert(TbMerchantModel tbMerchantModel);

    /**
     * 更新商家
     *
     * @param tbMerchantModel 商家
     * @return 更新的状态
     */
    Res<?> update(TbMerchantModel tbMerchantModel);

    /**
     * 通过ID删除单个商家
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(String id);

}