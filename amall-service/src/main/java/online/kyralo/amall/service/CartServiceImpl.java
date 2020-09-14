package online.kyralo.amall.service;

import online.kyralo.amall.api.CartService;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommoditySkuStockDO;
import online.kyralo.amall.dao.mapper.TbCommoditySkuStockDAO;
import online.kyralo.amall.manager.CartManager;
import online.kyralo.amall.manager.dto.CartDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CartServiceImpl implements CartService {

    @Resource
    private CartManager cartManager;
    @Resource
    private TbCommoditySkuStockDAO tbCommoditySkuStockDAO;

    @Override
    public Res<?> insert(String userId, String commodityId, Integer commodityStockId, Integer addCount) {
        Integer result = cartManager.insert(userId, commodityId, commodityStockId, addCount);

        if (result == 0) {
            return ResUtil.error();
        }

        return ResUtil.success();
    }

    @Override
    public Res<?> updateAddCount(String userId, String commodityId, Integer commodityStockId, Integer addCount) {

        TbCommoditySkuStockDO tbCommoditySkuStockDO =
                tbCommoditySkuStockDAO.selectByPrimaryKey(commodityStockId);
        if (tbCommoditySkuStockDO == null) {
            return ResUtil.error();
        }

        Integer databaseCount = tbCommoditySkuStockDO.getQuantity();
        if (addCount > databaseCount) {
            return ResUtil.error();
        }

        Integer result = cartManager.updateAddCount(userId, commodityId, commodityStockId, addCount);

        if (result == 0) {
            return ResUtil.error();
        }

        return ResUtil.success();
    }

    @Override
    public Res<?> remove(String userId, String commodityId, Integer commodityStockId) {

        if (cartManager.remove(userId, commodityId, commodityStockId) == 0) {
            return ResUtil.error();
        }

        return ResUtil.success();
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> countByUserId(String userId) {
        Long result = cartManager.countByUserId(userId);
        return ResUtil.success(result);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> listCartByUserId(String userId, Integer pageNum, Integer pageSize) {
        List<CartDTO> cartDtos = cartManager.listCartByUserId(userId, pageNum, pageSize);
        if (cartDtos.isEmpty()) {
            return ResUtil.error();
        }

        // TODO 处理

        


        return null;
    }

}
