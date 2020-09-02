package online.kyralo.amall.service;

import online.kyralo.amall.api.CartService;
import online.kyralo.amall.common.api.Res;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CartServiceImpl implements CartService {

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String userId) {
        return null;
    }

    @Override
    public Res<?> insert(String userId, String commodityId, Integer addCount) {
        return null;
    }

    @Override
    public Res<?> updateAddCount(String userId, String commodityId, Integer addCount) {
        return null;
    }

    @Override
    public Res<?> remove(String userId, String commodityId) {
        return null;
    }

    @Override
    public Res<?> countByUserId(String userId) {
        return null;
    }

    @Override
    public Res<?> listCartByUserId(String userId) {
        return null;
    }

}
