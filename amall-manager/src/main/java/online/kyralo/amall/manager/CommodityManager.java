package online.kyralo.amall.manager;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.RedisUtil;
import online.kyralo.amall.common.utils.StringUtil;
import online.kyralo.amall.dao.dataobject.*;
import online.kyralo.amall.dao.mapper.*;
import online.kyralo.amall.manager.dto.CommodityDTO;
import online.kyralo.amall.manager.dto.ParameterDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static online.kyralo.amall.common.constants.CommodityConstant.CACHE_COMMODITY_SERVICE_INFO;

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
    @Resource
    private TbCommodityBrandsDAO tbCommodityBrandsDAO;
    @Resource
    private TbCommodityCategoryDAO tbCommodityCategoryDAO;
    @Resource
    private TbCommoditySkuStockDAO tbCommoditySkuStockDAO;
    @Resource
    private TbCommoditySizeDAO tbCommoditySizeDAO;
    @Resource
    private TbCommodityAttrDAO tbCommodityAttrDAO;
    @Resource
    private TbCommodityAttrValueDAO tbCommodityAttrValueDAO;

    /**
     * 查询简略商品信息 通过商品 sku id
     *
     * @param commoditySkuId 商品 sku id
     * @return 商品信息
     */
    public CommodityDTO querySimpleCommodityById(String commoditySkuId) {

        CommodityDTO commodity = new CommodityDTO();

        // 商品SKU
        TbCommoditySkuDO tbCommoditySkuDO =
                tbCommoditySkuDAO.selectByPrimaryKey(commoditySkuId);


        // 商品SPU
        String spuId = tbCommoditySkuDO.getSpuId();
        TbCommoditySpuDO tbCommoditySpuDO =
                tbCommoditySpuDAO.selectByPrimaryKey(spuId);

        // 品牌
        String brandId = tbCommoditySpuDO.getBrandId();
        TbCommodityBrandsDO tbCommodityBrandsDO =
                tbCommodityBrandsDAO.selectByPrimaryKey(brandId);

        // 分类
        Integer childCategoryId = tbCommoditySpuDO.getCategoryId();
        TbCommodityCategoryDO secondCategoryDO =
                tbCommodityCategoryDAO.selectByPrimaryKey(childCategoryId);

        Integer primaryCategoryId = secondCategoryDO.getParentCategoryId();
        TbCommodityCategoryDO primaryCategoryDO =
                tbCommodityCategoryDAO.selectByPrimaryKey(primaryCategoryId);




        return null;
    }

    /**
     * 查询商品信息 通过商品 sku id
     *
     * @param commoditySkuId 商品 sku id
     * @return 商品信息
     */
    @SuppressWarnings("unchecked")
    public CommodityDTO queryCommodityById(String commoditySkuId) {

        CommodityDTO commodity = new CommodityDTO();

        // 商品SKU
        TbCommoditySkuDO tbCommoditySkuDO =
                tbCommoditySkuDAO.selectByPrimaryKey(commoditySkuId);
        if (tbCommoditySkuDO == null) {
            return null;
        }

        // 商品预览图 列表
        // 商品介绍主图 多个图片逗号分隔


        // 商品SPU
        String spuId = tbCommoditySkuDO.getSpuId();
        TbCommoditySpuDO tbCommoditySpuDO =
                tbCommoditySpuDAO.selectByPrimaryKey(spuId);

        // 品牌
        String brandId = tbCommoditySpuDO.getBrandId();
        TbCommodityBrandsDO tbCommodityBrandsDO =
                tbCommodityBrandsDAO.selectByPrimaryKey(brandId);

        // 分类
        Integer childCategoryId = tbCommoditySpuDO.getCategoryId();
        TbCommodityCategoryDO secondCategoryDO =
                tbCommodityCategoryDAO.selectByPrimaryKey(childCategoryId);

        Integer primaryCategoryId = secondCategoryDO.getParentCategoryId();
        TbCommodityCategoryDO primaryCategoryDO =
                tbCommodityCategoryDAO.selectByPrimaryKey(primaryCategoryId);


        // 服务说明 [缓存拿]
        Object infoResult = RedisUtil.getHash(CACHE_COMMODITY_SERVICE_INFO, commoditySkuId);
        if (infoResult != null) {
            List<String> serviceInfos = CopyUtil.copyList(infoResult, String.class);
            commodity.setServiceInfo(serviceInfos);
        }

        // 产品参数
        String commodityParameters = tbCommoditySkuDO.getCommodityParameters();




        // 穿着效果
        String commodityInEffectStr = tbCommoditySkuDO.getCommodityInEffect();
        List<String> commodityInEffect = StringUtil.commaSpilt(commodityInEffectStr);
        commodity.setCommodityInEffectImages(commodityInEffect);

        // 尺码说明
        List<String> commoditySizeIds =
                StringUtil.commaSpilt(tbCommoditySkuDO.getCommoditySizeSpecification());

        ArrayList<ParameterDTO<List<ParameterDTO<String>>>> commoditySizesSpec = Lists.newArrayList();

        commoditySizeIds.forEach(commoditySizeId -> {

            ParameterDTO<List<ParameterDTO<String>>> sizeParameter = new ParameterDTO<>();

            TbCommoditySizeDO tbCommoditySizeDO =
                    tbCommoditySizeDAO.selectByPrimaryKey(commoditySizeId);
            String sizeName = tbCommoditySizeDO.getSizeName();
            String valueJson = tbCommoditySizeDO.getSizeDesc();

            List<ParameterDTO<String>> objects = (List<ParameterDTO<String>>)JSON.parse(valueJson);

            sizeParameter.setName(sizeName);
            sizeParameter.setValue(objects);

        });

        commodity.setCommoditySizeSpec(commoditySizesSpec);


        // 商品销售属性

        // 商品套餐 [缓存拿]

        return null;
    }

}
