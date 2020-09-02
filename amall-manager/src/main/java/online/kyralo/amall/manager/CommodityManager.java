package online.kyralo.amall.manager;

import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.dao.mapper.TbCommoditySkuDAO;
import online.kyralo.amall.dao.mapper.TbCommoditySpuDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/7/9
 * \* Time: 7:41
 * \* Description: 商品 复合查询
 * \
 */

@Component
public class CommodityManager {

    @Resource
    private TbCommoditySpuDAO tbCommoditySpuDAO;
    @Resource
    private TbCommoditySkuDAO tbCommoditySkuDAO;

    /**
     * 查询商品信息 通过商品 sku id
     *
     * @param commoditySkuId 商品 sku id
     * @return 商品信息
     */
    public Res<?> queryCommodityById(String commoditySkuId) {



        return null;
    }

}
