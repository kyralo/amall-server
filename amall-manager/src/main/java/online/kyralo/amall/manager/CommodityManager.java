package online.kyralo.amall.manager;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.RedisUtil;
import online.kyralo.amall.common.utils.StringUtil;
import online.kyralo.amall.dao.dataobject.*;
import online.kyralo.amall.dao.mapper.*;
import online.kyralo.amall.manager.dto.*;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static online.kyralo.amall.common.constants.CommodityConstant.CACHE_COMMODITY_DISCOUNT_PREFIX;
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
    private ExecutorService executorService;

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
    @Resource
    private TbOrderDAO tbOrderDAO;

    public CommodityDTO querySimpleCommodityBySpuId(String commoditySpuId, String currentColor, String currentSize) throws InterruptedException {
        TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findBySpuId(commoditySpuId);
        String id = tbCommoditySkuDO.getId();
        return querySimpleCommodityById(id, currentColor, currentSize);
    }

    /**
     * 查询简略商品信息 通过商品 sku id
     *
     * @param commoditySkuId 商品 sku id
     * @return 商品信息
     */
    public CommodityDTO querySimpleCommodityById(String commoditySkuId, String currentColor, String currentSize) throws InterruptedException {

        CommodityDTO commodity = new CommodityDTO();
        CountDownLatch countDownLatch = new CountDownLatch(6);
        // 商品SKU
        TbCommoditySkuDO tbCommoditySkuDO =
                tbCommoditySkuDAO.selectByPrimaryKey(commoditySkuId);
        if (tbCommoditySkuDO == null) {
            return null;
        }
        // 商品预览图 列表 [缓存]
        String bannerUrls = tbCommoditySkuDO.getBannerUrl();
        List<String> bannerUrlList = StringUtil.commaSpilt(bannerUrls);
        commodity.setPreImgUrls(bannerUrlList);
        // 商品介绍主图 多个图片逗号分隔
        commodity.setMainUrls(bannerUrlList);
        // 当前选择商品
        // ->> 颜色
        commodity.setCurrentColor(currentColor);
        // ->> 尺寸
        commodity.setCurrentSize(currentSize);
        // 商品SPU
        String spuId = tbCommoditySkuDO.getSpuId();
        TbCommoditySpuDO tbCommoditySpuDO =
                tbCommoditySpuDAO.selectByPrimaryKey(spuId);
        commodity.setName(tbCommoditySpuDO.getName());
        commodity.setSellingPoint(tbCommoditySpuDO.getSellingPoint());
        commodity.setUnit(tbCommoditySpuDO.getUnit());
        executorService.submit(() -> {
            // 品牌
            String brandId = tbCommoditySpuDO.getBrandId();
            TbCommodityBrandsDO tbCommodityBrandsDO =
                    tbCommodityBrandsDAO.selectByPrimaryKey(brandId);
            commodity.setBrandId(brandId);
            commodity.setBrandName(tbCommodityBrandsDO.getName());
            commodity.setBrandLogo(tbCommodityBrandsDO.getLogoUrl());
            countDownLatch.countDown();
        });
        executorService.submit(() -> {
            // 分类
            Integer childCategoryId = tbCommoditySpuDO.getCategoryId();
            TbCommodityCategoryDO secondCategoryDO =
                    tbCommodityCategoryDAO.selectByPrimaryKey(childCategoryId);
            Integer primaryCategoryId = secondCategoryDO.getParentCategoryId();
            TbCommodityCategoryDO primaryCategoryDO =
                    tbCommodityCategoryDAO.selectByPrimaryKey(primaryCategoryId);
            commodity.setPrimaryCategoryId(primaryCategoryDO.getId());
            commodity.setPrimaryCategoryName(primaryCategoryDO.getName());
            commodity.setChildCategoryId(secondCategoryDO.getId());
            commodity.setChildCategoryName(secondCategoryDO.getName());
            countDownLatch.countDown();
        });
        executorService.submit(() -> {
            // ->> 价格
            Integer currentPriceFee = tbCommoditySkuDO.getPriceFee();
            Integer currentPriceScale = tbCommoditySkuDO.getPriceScale();
            Double currentPrice = currentPriceFee * Math.pow(10, -currentPriceScale);
            commodity.setCurrentPrice(currentPrice);
            countDownLatch.countDown();
        });
        executorService.submit(() -> {
            // ->> 库存
            Integer currentQuantity = tbCommoditySkuStockDAO.findQuantityBySkuIdAndColorAndSize(commoditySkuId, currentColor, currentSize);
            commodity.setCurrentStock(currentQuantity);

            countDownLatch.countDown();
        });
        executorService.submit(() -> {
            // ->> 折扣
            String key = CACHE_COMMODITY_DISCOUNT_PREFIX + commoditySkuId;
            String objectKey = commoditySkuId + "_" + currentColor + "_" + currentSize;
            Float result = (Float) RedisUtil.getHash(key, objectKey);
            commodity.setCurrentDiscount(result);
            countDownLatch.countDown();
        });
        executorService.submit(() -> {
            // ->> 月销量
            int cumulativeSales = tbOrderDAO.countCurrentMonthOrderBySkuId(commoditySkuId);
            commodity.setCumulativeSales(cumulativeSales);
            countDownLatch.countDown();
        });
        countDownLatch.await();
        return commodity;
    }

    /**
     * 查询商品信息 通过商品 sku id
     *
     * @param commoditySkuId 商品 sku id
     * @return 商品信息
     */
    @SuppressWarnings("unchecked")
    public CommodityDTO queryCommodityById(String commoditySkuId, String currentColor, String currentSize) throws InterruptedException {
        CommodityDTO commodity = new CommodityDTO();

        CountDownLatch countDownLatch = new CountDownLatch(6);

        // 商品SKU
        TbCommoditySkuDO tbCommoditySkuDO =
                tbCommoditySkuDAO.selectByPrimaryKey(commoditySkuId);
        if (tbCommoditySkuDO == null) {
            return null;
        }
        // 商品预览图 列表 [缓存]
        String bannerUrls = tbCommoditySkuDO.getBannerUrl();
        List<String> bannerUrlList = StringUtil.commaSpilt(bannerUrls);
        commodity.setPreImgUrls(bannerUrlList);
        // 商品介绍主图 多个图片逗号分隔
        commodity.setMainUrls(bannerUrlList);
        // 商品SPU
        String spuId = tbCommoditySkuDO.getSpuId();
        TbCommoditySpuDO tbCommoditySpuDO =
                tbCommoditySpuDAO.selectByPrimaryKey(spuId);
        commodity.setName(tbCommoditySpuDO.getName());
        commodity.setSellingPoint(tbCommoditySpuDO.getSellingPoint());
        commodity.setUnit(tbCommoditySpuDO.getUnit());
        commodity.setStatus(tbCommoditySpuDO.getStatus());
        commodity.setCreateTime(tbCommoditySpuDO.getCreateTime());
        commodity.setUpdateTime(tbCommoditySpuDO.getUpdateTime());

        executorService.submit(() -> {
            // 品牌
            String brandId = tbCommoditySpuDO.getBrandId();
            TbCommodityBrandsDO tbCommodityBrandsDO =
                    tbCommodityBrandsDAO.selectByPrimaryKey(brandId);
            commodity.setBrandId(brandId);
            commodity.setBrandName(tbCommodityBrandsDO.getName());
            commodity.setBrandLogo(tbCommodityBrandsDO.getLogoUrl());

            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            // 分类
            Integer childCategoryId = tbCommoditySpuDO.getCategoryId();
            TbCommodityCategoryDO secondCategoryDO =
                    tbCommodityCategoryDAO.selectByPrimaryKey(childCategoryId);
            Integer primaryCategoryId = secondCategoryDO.getParentCategoryId();
            TbCommodityCategoryDO primaryCategoryDO =
                    tbCommodityCategoryDAO.selectByPrimaryKey(primaryCategoryId);
            commodity.setPrimaryCategoryId(primaryCategoryDO.getId());
            commodity.setPrimaryCategoryName(primaryCategoryDO.getName());
            commodity.setChildCategoryId(secondCategoryDO.getId());
            commodity.setChildCategoryName(secondCategoryDO.getName());

            countDownLatch.countDown();
        });

        // 当前选择商品
        // ->> 颜色
        commodity.setCurrentColor(currentColor);
        // ->> 尺寸
        commodity.setCurrentSize(currentSize);
        // ->> 价格
        Integer currentPriceFee = tbCommoditySkuDO.getPriceFee();
        Integer currentPriceScale = tbCommoditySkuDO.getPriceScale();
        Double currentPrice = currentPriceFee * Math.pow(10, - currentPriceScale);
        commodity.setCurrentPrice(currentPrice);

        executorService.submit(() -> {
            // ->> 库存
            Integer currentQuantity = tbCommoditySkuStockDAO.findQuantityBySkuIdAndColorAndSize(commoditySkuId, currentColor, currentSize);
            commodity.setCurrentStock(currentQuantity);

            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            // ->> 折扣
            String objectKey = commoditySkuId + "_" + currentColor + "_" + currentSize;
            Float result = (Float)RedisUtil.getHash(CACHE_COMMODITY_DISCOUNT_PREFIX + commoditySkuId, objectKey);
            commodity.setCurrentDiscount(result);

            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            // ->> 月销量
            int cumulativeSales = tbOrderDAO.countCurrentMonthOrderBySkuId(commoditySkuId);
            commodity.setCumulativeSales(cumulativeSales);

            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            // 服务说明 [缓存拿]
            Object infoResult = RedisUtil.getHash(CACHE_COMMODITY_SERVICE_INFO, commoditySkuId);
            if (infoResult != null) {
                List<String> serviceInfos = CopyUtil.copyList(infoResult, String.class);
                commodity.setServiceInfo(serviceInfos);
            }

            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            // 产品参数
            String commodityParametersStr = tbCommoditySkuDO.getCommodityParameters();
            List<ParameterDTO<String>> commodityParameters = new ArrayList<>();
            List<String> commodityParameterAttrIds = StringUtil.commaSpilt(commodityParametersStr);
            commodityParameterAttrIds.forEach(commodityParameterAttrId -> {
                TbCommodityAttrDO tbCommodityAttrDO =
                        tbCommodityAttrDAO.selectByPrimaryKey(commodityParameterAttrId);
                if (tbCommodityAttrDO != null){
                    ParameterDTO<String> parameterDTO = new ParameterDTO<>();
                    String name = tbCommodityAttrDO.getName();
                    String attrDesc = tbCommodityAttrDO.getAttrDesc();
                    parameterDTO.setName(name);
                    parameterDTO.setValue(attrDesc);
                    commodityParameters.add(parameterDTO);
                }
            });

            // ->> 尺码添加
            ParameterDTO<String> parameterDTO = new ParameterDTO<>();
            List<String> sizeNameList = tbCommoditySizeDAO.findSizeNameBySkuId(commoditySkuId);
            String sizeNames = StringUtil.commaCombine(sizeNameList);
            parameterDTO.setName("size");
            parameterDTO.setValue(sizeNames);
            commodityParameters.add(parameterDTO);
            commodity.setCommodityParameters(commodityParameters);

            countDownLatch.countDown();
        });


        executorService.submit(() -> {
            // 穿着效果
            String commodityInEffectStr = tbCommoditySkuDO.getCommodityInEffect();
            List<String> commodityInEffect = StringUtil.commaSpilt(commodityInEffectStr);
            commodity.setCommodityInEffectImages(commodityInEffect);

            countDownLatch.countDown();
        });


        executorService.submit(() -> {
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

            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            // 商品销售属性
            List<ParameterDTO<List<SalesValueDTO>>> sales = new ArrayList<>();
            List<String> colors = tbCommoditySkuStockDAO.findColorNameBySkuId(commoditySkuId);
            // todo ...
            Integer priceFee = tbCommoditySkuDO.getPriceFee();
            Integer priceScale = tbCommoditySkuDO.getPriceScale();
            Double price = priceFee * Math.pow(10, - priceScale);
            colors.forEach(colorName -> {
                ParameterDTO<List<SalesValueDTO>> listParameterDTO = new ParameterDTO<>();
                listParameterDTO.setName(colorName);
                List<SalesValueDTO> salesValueList = new ArrayList<>();
                List<String> sizeList =
                        tbCommoditySkuStockDAO.findSizeNameBySkuIdAndColorName(commoditySkuId, colorName);
                sizeList.forEach(sizeName -> {
                    SalesValueDTO salesValueDTO = new SalesValueDTO();
                    salesValueDTO.setSizeName(sizeName);
                    TbCommoditySizeDO tbCommoditySizeDO =
                            tbCommoditySizeDAO.findBySkuIdAndName(commoditySkuId, sizeName);
                    CommoditySizeDTO commoditySizeDTO = new CommoditySizeDTO();
                    CopyUtil.copyBean(tbCommoditySizeDO, commoditySizeDTO);
                    salesValueDTO.setSizeInfo(commoditySizeDTO);
                    Example.Criteria criteria = new Example(TbCommoditySkuStockDO.class).createCriteria();
                    criteria.andEqualTo("sku_id", commoditySkuId)
                            .andEqualTo("sku_color", colorName)
                            .andEqualTo("sku_size_name", sizeName);
                    TbCommoditySkuStockDO tbCommoditySkuStockDO = tbCommoditySkuStockDAO.selectOneByExample(criteria);
                    salesValueDTO.setStock(tbCommoditySkuStockDO.getId());
                    // todo ...
                    salesValueDTO.setPrice(price);
                    // 商品折扣 [缓存]
                    String commodityObjectKey = commoditySkuId + "_" + colorName + "_" + sizeName;
                    Float discountResult = (Float)RedisUtil.getHash(CACHE_COMMODITY_DISCOUNT_PREFIX + commoditySkuId, commodityObjectKey);
                    salesValueDTO.setDiscount(discountResult);
                    // 商品存货
                    Integer quantity = tbCommoditySkuStockDAO.findQuantityBySkuIdAndColorAndSize(commoditySkuId, currentColor, currentSize);
                    commodity.setCurrentStock(quantity);
                    salesValueList.add(salesValueDTO);
                });
                listParameterDTO.setValue(salesValueList);
                sales.add(listParameterDTO);
            });
            commodity.setSales(sales);

            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            // 商品套餐 [缓存拿]
            String comboKey = CACHE_COMMODITY_DISCOUNT_PREFIX + commoditySkuId;
            Set<Object> hashKeys = RedisUtil.getHashKeys(comboKey);
            List<Object> comboObjectList = RedisUtil.getHash(comboKey, hashKeys);
            List<ComboDTO> combos = CopyUtil.copyList(comboObjectList, ComboDTO.class);
            commodity.setCombos(combos);

            countDownLatch.countDown();
        });

        countDownLatch.await();

        return commodity;
    }

    /**
     * 修改商品折扣
     */
    public Boolean changeDiscount(String commoditySkuId, String currentColor, String currentSize, Double discount){
        String key = CACHE_COMMODITY_DISCOUNT_PREFIX + commoditySkuId;
        String objectKey = commoditySkuId + "_" + currentColor + "_" + currentSize;
        RedisUtil.putHash(key, objectKey, discount);
        return true;
    }

}
