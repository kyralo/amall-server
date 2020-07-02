package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbUserAddressModel;
import online.kyralo.amall.common.api.Res;

/**
 * 用户地址
 */
public interface TbUserAddressService {

    /**
     * 通过ID查询单个用户地址
     *
     * @param id ID
     * @return {@link TbUserAddressModel}
     */
    Res<?> findById(Integer id);

    /**
     * 分页查询用户地址
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbUserAddressModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增用户地址
     *
     * @param tbUserAddressModel 用户地址
     * @return 新增的状态
     */
    Res<?> insert(TbUserAddressModel tbUserAddressModel);

    /**
     * 更新用户地址
     *
     * @param tbUserAddressModel 用户地址
     * @return 更新的状态
     */
    Res<?> update(TbUserAddressModel tbUserAddressModel);

    /**
     * 通过ID删除单个用户地址
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(Integer id);

}