package online.kyralo.amall.api;


import online.kyralo.amall.api.model.TbOrderModel;
import online.kyralo.amall.common.api.Res;

/**
 * 订单
 */
public interface TbOrderService {

    /**
     * 通过ID查询单个订单
     *
     * @param id ID
     * @return {@link TbOrderModel}
     */
    Res<?> findById(Integer id);

    /**
     * 分页查询订单
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link TbOrderModel}
     */
    Res<?> findByPage(int pageNum, int pageSize);

    /**
     * 新增订单
     *
     * @param tbOrderModel 订单
     * @return 新增的状态
     */
    Res<?> insert(TbOrderModel tbOrderModel);

    /**
     * 更新订单
     *
     * @param tbOrderModel 订单
     * @return 更新的状态
     */
    Res<?> update(TbOrderModel tbOrderModel);

    /**
     * 通过ID删除单个订单
     *
     * @param id ID
     * @return 删除的状态
     */
    Res<?> deleteById(Integer id);

}