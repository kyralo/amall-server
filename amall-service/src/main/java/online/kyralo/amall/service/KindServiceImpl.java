package online.kyralo.amall.service;

import online.kyralo.amall.api.KindService;
import online.kyralo.amall.api.bo.TbCommodityCategoryBO;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommodityCategoryDO;
import online.kyralo.amall.dao.mapper.TbCommodityCategoryDAO;
import online.kyralo.amall.dao.mapper.TbCommoditySpuDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/27
 * \* Time: 6:33
 * \* Description: 商品类型
 * \
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class KindServiceImpl implements KindService {

    @Resource
    private TbCommodityCategoryDAO tbCommodityCategoryDAO;
    @Resource
    private TbCommoditySpuDAO tbCommoditySpuDAO;

    @Override
    public Res<?> listKinds() {

        List<Map<String, Object>> mapList = new ArrayList<>();

        List<TbCommodityCategoryDO> primaryCategories = tbCommodityCategoryDAO.listPrimaryCategories();

        if (primaryCategories.isEmpty()){
            return ResUtil.success();
        }

        primaryCategories.forEach(primaryCategory -> {
            Integer primaryId = primaryCategory.getId();
            List<TbCommodityCategoryDO> secondCategories =
                    tbCommodityCategoryDAO.listSecondCategories(primaryId);

            Map<String, Object> map = new HashMap<>(2);
            map.put("primaryCategory", primaryCategory);
            map.put("secondCategories", secondCategories);
            mapList.add(map);
        });

        return ResUtil.success(mapList);
    }

    @Override
    public Res<?> listKindsByMerchantId(String merchantId) {

        Set<Object> primaryCategoriesDO = new HashSet<>();

        List<Integer> secondCategories =
                tbCommoditySpuDAO.listSecondTypeIdByMerchantId(merchantId);

        if (secondCategories.isEmpty()){
            return ResUtil.success();
        }

        secondCategories.forEach(secondCategoryId -> {
            TbCommodityCategoryDO primaryCategory =
                    tbCommodityCategoryDAO.findById(secondCategoryId);

            primaryCategoriesDO.add(primaryCategory.getParentCategoryId());
        });

        List<TbCommodityCategoryBO> primaryCategories = CopyUtil.copyList(primaryCategoriesDO, TbCommodityCategoryBO.class);

        return ResUtil.success(primaryCategories);
    }
}
