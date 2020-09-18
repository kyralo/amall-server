package online.kyralo.amall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import online.kyralo.amall.api.CommodityService;
import online.kyralo.amall.api.bo.CommodityBO;
import online.kyralo.amall.api.model.ComboModel;
import online.kyralo.amall.common.annotation.NewCache;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.constants.CacheEnum;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.RedisUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.*;
import online.kyralo.amall.dao.mapper.*;
import online.kyralo.amall.manager.CommodityManager;
import online.kyralo.amall.manager.dto.CommodityDTO;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;

import static online.kyralo.amall.common.constants.CommodityConstant.CACHE_COMMODITY_COMBO_PREFIX;
import static online.kyralo.amall.common.constants.RedisConstant.CACHE_TB_KEY_PREFIX;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/21
 * \* Time: 20:15
 * \* Description: 商品
 * \
 */

@Slf4j
@Service
public class CommodityServiceImpl implements CommodityService {

    @Resource
    private ExecutorService executorService;

    @Resource
    private CommodityManager commodityManager;

    @Resource
    private TbCommodityCategoryDAO tbCommodityCategoryDAO;
    @Resource
    private TbCommoditySpuDAO tbCommoditySpuDAO;
    @Resource
    private TbCommoditySkuDAO tbCommoditySkuDAO;
    @Resource
    private TbCommoditySkuStockDAO tbCommoditySkuStockDAO;
    @Resource
    private TbUserCollectionDAO tbUserCollectionDAO;

    @NewCache(value = CACHE_TB_KEY_PREFIX + "commodity", key = "commoditySkuId", type = CacheEnum.QUERY)
    @Override
    public Res<?> queryById(String commoditySkuId, String currentColor, String currentSize) throws InterruptedException {
        CommodityDTO commodityDTO = commodityManager.queryCommodityById(commoditySkuId, currentColor, currentSize);
        CommodityBO commodity = new CommodityBO();
        CopyUtil.copyBean(commodityDTO, commodity);
        return ResUtil.success(commodity);
    }

    private void typeAll(List<Map<String, String>> mapList){
        // 查询全部
        List<TbCommodityCategoryDO> primaryCategories = tbCommodityCategoryDAO.listPrimaryCategories();
        primaryCategories.forEach(primaryCategory -> {
            Integer primaryId = primaryCategory.getId();
            List<TbCommodityCategoryDO> secondCategories =
                    tbCommodityCategoryDAO.listSecondCategories(primaryId);
            secondCategories.forEach(secondCategory -> {
                List<String> spuIds = tbCommoditySpuDAO.findByType(secondCategory.getId());
                spuIds.forEach(spuId -> {
                    TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findBySpuId(spuId);
                    String skuId = tbCommoditySkuDO.getId();
                    List<TbCommoditySkuStockDO> tbCommoditySkuStocks = tbCommoditySkuStockDAO.findBySkuId(skuId);
                    if (!tbCommoditySkuStocks.isEmpty()){
                        TbCommoditySkuStockDO tbCommoditySkuStock0 = tbCommoditySkuStocks.get(0);
                        Map<String, String> map = new HashMap<>(3);
                        map.put("skuId", skuId);
                        map.put("color", tbCommoditySkuStock0.getSkuColor());
                        map.put("sizeName", tbCommoditySkuStock0.getSkuSizeName());
                        mapList.add(map);
                    }
                });
            });
        });
    }

    private void typePrimary(List<Map<String, String>> mapList, String primaryType){
        List<Integer> secondCategoryIds = tbCommodityCategoryDAO.listSecondCategoryIdsByPrimaryType(primaryType);
        secondCategoryIds.forEach(secondCategoryId -> {
            List<String> spuIds = tbCommoditySpuDAO.findByType(secondCategoryId);
            spuIds.forEach(spuId -> {
                TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findBySpuId(spuId);
                String skuId = tbCommoditySkuDO.getId();
                List<TbCommoditySkuStockDO> tbCommoditySkuStocks = tbCommoditySkuStockDAO.findBySkuId(skuId);
                if (!tbCommoditySkuStocks.isEmpty()){
                    TbCommoditySkuStockDO tbCommoditySkuStock0 = tbCommoditySkuStocks.get(0);
                    Map<String, String> map = new HashMap<>(3);
                    map.put("skuId", skuId);
                    map.put("color", tbCommoditySkuStock0.getSkuColor());
                    map.put("sizeName", tbCommoditySkuStock0.getSkuSizeName());
                    mapList.add(map);
                }
            });
        });
    }

    private void typeSecond(List<Map<String, String>> mapList, String secondType){
        TbCommodityCategoryDO secondCategory = tbCommodityCategoryDAO.findByName(secondType);
        List<String> spuIds = tbCommoditySpuDAO.findByType(secondCategory.getId());
        spuIds.forEach(spuId -> {
            TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findBySpuId(spuId);
            String skuId = tbCommoditySkuDO.getId();
            List<TbCommoditySkuStockDO> tbCommoditySkuStocks = tbCommoditySkuStockDAO.findBySkuId(skuId);
            if (!tbCommoditySkuStocks.isEmpty()){
                TbCommoditySkuStockDO tbCommoditySkuStock0 = tbCommoditySkuStocks.get(0);
                Map<String, String> map = new HashMap<>(3);
                map.put("skuId", skuId);
                map.put("color", tbCommoditySkuStock0.getSkuColor());
                map.put("sizeName", tbCommoditySkuStock0.getSkuSizeName());
                mapList.add(map);
            }
        });
    }

    @Override
    public Res<?> listByCategory(String primaryType, String secondType, Integer pageNum, Integer pageSize) throws InterruptedException {
        List<CommodityBO> commodities;
        List<Map<String, String>> mapList = new ArrayList<>();
        if (primaryType == null) {
            // 查询全部
            typeAll(mapList);
        }

        if (secondType == null) {
            // 二级类型
            typePrimary(mapList, primaryType);
        }

        // 查询指定类型
        if (primaryType != null && secondType != null){
            typeSecond(mapList, secondType);
        }

        List<CommodityDTO> commodityDTOList = new ArrayList<>();
        mapList.forEach(map -> {
            try {
                CommodityDTO commodityDTO =
                        commodityManager.querySimpleCommodityById(map.get("skuId"), map.get("color"), map.get("sizeName"));
                commodityDTOList.add(commodityDTO);

            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
        });
        commodities = CopyUtil.copyList(commodityDTOList, CommodityBO.class);
        return ResUtil.success(commodities);
    }

    @Override
    public Res<?> listHomeShowModules() {
        return null;
    }

    private void listLatestCommodities(List<Map<String, String>> mapList, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<TbCommoditySkuDO> tbCommoditySkus = tbCommoditySkuDAO.findByPage();

        List<TbCommoditySkuDO> tbCommoditySkuList = tbCommoditySkus.getResult();

        if (tbCommoditySkuList.isEmpty()){
            return;
        }

        tbCommoditySkuList.forEach(tbCommoditySku -> {

            String skuId = tbCommoditySku.getId();
            List<TbCommoditySkuStockDO> tbCommoditySkuStocks = tbCommoditySkuStockDAO.findBySkuId(skuId);
            TbCommoditySkuStockDO tbCommoditySkuStock0 = tbCommoditySkuStocks.get(0);
            Map<String, String> map = new HashMap<>(3);
            map.put("skuId", skuId);
            map.put("color", tbCommoditySkuStock0.getSkuColor());
            map.put("sizeName", tbCommoditySkuStock0.getSkuSizeName());
            mapList.add(map);

        });

    }

    @Override
    public Res<?> listHomeRecommondCommodities(String userId, Integer pageNum, Integer pageSize) {
        List<CommodityBO> commodities;
        List<Map<String, String>> mapList = new ArrayList<>();

        if (userId == null || "".equals(userId)) {
            listLatestCommodities(mapList, pageNum, pageSize);

            if (mapList.isEmpty()){
                return ResUtil.success();
            }

            List<CommodityDTO> commodityDTOList = new ArrayList<>();
            mapList.forEach(map -> {
                try {
                    CommodityDTO commodityDTO =
                            commodityManager.querySimpleCommodityById(map.get("skuId"), map.get("color"), map.get("sizeName"));
                    commodityDTOList.add(commodityDTO);

                } catch (InterruptedException e) {
                    log.info(e.getMessage());
                }
            });
            commodities = CopyUtil.copyList(commodityDTOList, CommodityBO.class);
            return ResUtil.success(commodities);
        }

        List<TbUserCollectionDO> userCollections = tbUserCollectionDAO.listByUserId(userId);
        if (userCollections.isEmpty()) {
            listLatestCommodities(mapList, pageNum, pageSize);

            if (mapList.isEmpty()){
                return ResUtil.success();
            }

            List<CommodityDTO> commodityDTOList = new ArrayList<>();
            mapList.forEach(map -> {
                try {
                    CommodityDTO commodityDTO =
                            commodityManager.querySimpleCommodityById(map.get("skuId"), map.get("color"), map.get("sizeName"));
                    commodityDTOList.add(commodityDTO);

                } catch (InterruptedException e) {
                    log.info(e.getMessage());
                }
            });
            commodities = CopyUtil.copyList(commodityDTOList, CommodityBO.class);
            return ResUtil.success(commodities);
        }





        return null;
    }

    @Override
    public Res<?> listRecommondCommodities(String commoditySkuId, Integer pageNum, Integer pageSize) {
        // 商品页
        List<CommodityBO> commodities;
        List<Map<String, String>> mapList = new ArrayList<>();



        return null;
    }

    @Override
    public Res<?> listMerchantCommodities(String merchantId, String primaryType, Integer pageNum, Integer pageSize) {

        List<CommodityBO> commodities;
        List<Map<String, String>> mapList = new ArrayList<>();

        if (primaryType == null || "".equals(primaryType)) {

            Example example = new Example(TbCommoditySpuDO.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("merchantId", merchantId);
            List<TbCommoditySpuDO> tbCommoditySpuList = tbCommoditySpuDAO.selectByExample(example);

            tbCommoditySpuList.forEach(tbCommoditySpu -> {
                String spuId =  tbCommoditySpu.getId();
                TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findBySpuId(spuId);
                String skuId = tbCommoditySkuDO.getId();
                List<TbCommoditySkuStockDO> tbCommoditySkuStocks = tbCommoditySkuStockDAO.findBySkuId(skuId);
                if (!tbCommoditySkuStocks.isEmpty()){
                    TbCommoditySkuStockDO tbCommoditySkuStock0 = tbCommoditySkuStocks.get(0);
                    Map<String, String> map = new HashMap<>(3);
                    map.put("skuId", skuId);
                    map.put("color", tbCommoditySkuStock0.getSkuColor());
                    map.put("sizeName", tbCommoditySkuStock0.getSkuSizeName());
                    mapList.add(map);
                }
            });

        } else {
            TbCommodityCategoryDO tbCommodityCategory =
                    tbCommodityCategoryDAO.findByName(primaryType);

            Integer id = tbCommodityCategory.getId();

            Example example = new Example(TbCommoditySpuDO.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("merchantId", merchantId);
            criteria.andEqualTo("category_id", id);
            List<TbCommoditySpuDO> tbCommoditySpuList = tbCommoditySpuDAO.selectByExample(example);

            tbCommoditySpuList.forEach(tbCommoditySpu -> {
                String spuId =  tbCommoditySpu.getId();
                TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findBySpuId(spuId);
                String skuId = tbCommoditySkuDO.getId();
                List<TbCommoditySkuStockDO> tbCommoditySkuStocks = tbCommoditySkuStockDAO.findBySkuId(skuId);
                if (!tbCommoditySkuStocks.isEmpty()){
                    TbCommoditySkuStockDO tbCommoditySkuStock0 = tbCommoditySkuStocks.get(0);
                    Map<String, String> map = new HashMap<>(3);
                    map.put("skuId", skuId);
                    map.put("color", tbCommoditySkuStock0.getSkuColor());
                    map.put("sizeName", tbCommoditySkuStock0.getSkuSizeName());
                    mapList.add(map);
                }
            });
        }

        List<CommodityDTO> commodityDTOList = new ArrayList<>();
        mapList.forEach(map -> {
            try {
                CommodityDTO commodityDTO =
                        commodityManager.querySimpleCommodityById(map.get("skuId"), map.get("color"), map.get("sizeName"));
                commodityDTOList.add(commodityDTO);

            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
        });
        commodities = CopyUtil.copyList(commodityDTOList, CommodityBO.class);
        return ResUtil.success(commodities);
    }

    @Override
    public Res<?> listMerchantRecommondCommodities(String merchantId, String commoditySkuId, Integer pageNum, Integer pageSize) {
        List<CommodityBO> commodities;
        List<Map<String, String>> mapList = new ArrayList<>();

        TbCommoditySkuDO sku = tbCommoditySkuDAO.findById(commoditySkuId);
        TbCommoditySpuDO spu = tbCommoditySpuDAO.findById(sku.getSpuId());
        TbCommodityCategoryDO category = tbCommodityCategoryDAO.findById(spu.getCategoryId());

        Integer secondId = category.getId();

        Example example = new Example(TbCommoditySpuDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("merchantId", merchantId)
                .andEqualTo("categoryId", secondId);
        List<TbCommoditySpuDO> tbCommoditySpuList = tbCommoditySpuDAO.selectByExample(example);
        tbCommoditySpuList.forEach(tbCommoditySpu -> {
            String spuId = tbCommoditySpu.getId();
            TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findBySpuId(spuId);
            String skuId = tbCommoditySkuDO.getId();
            List<TbCommoditySkuStockDO> tbCommoditySkuStocks = tbCommoditySkuStockDAO.findBySkuId(skuId);
            if (!tbCommoditySkuStocks.isEmpty()){
                TbCommoditySkuStockDO tbCommoditySkuStock0 = tbCommoditySkuStocks.get(0);
                Map<String, String> map = new HashMap<>(3);
                map.put("skuId", skuId);
                map.put("color", tbCommoditySkuStock0.getSkuColor());
                map.put("sizeName", tbCommoditySkuStock0.getSkuSizeName());
                mapList.add(map);
            }
        });

        List<CommodityDTO> commodityDTOList = new ArrayList<>();
        mapList.forEach(map -> {
            try {
                CommodityDTO commodityDTO =
                        commodityManager.querySimpleCommodityById(map.get("skuId"), map.get("color"), map.get("sizeName"));
                commodityDTOList.add(commodityDTO);

            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
        });
        commodities = CopyUtil.copyList(commodityDTOList, CommodityBO.class);
        return ResUtil.success(commodities);
    }

    @Override
    public Res<?> insertCommodityCombo(String commoditySkuId, ComboModel comboModel) {

        String comboId = UUID.randomUUID().toString().replace("-", "");
        RedisUtil.putHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId, comboModel);

        return ResUtil.success();
    }

    @Override
    public Res<?> updateCommodityCombo(String commoditySkuId, ComboModel comboModel) {

        String comboId = comboModel.getComboId();
        Object result = RedisUtil.getHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId);

        if (result == null) {
            return ResUtil.error();
        }

        CopyUtil.copyBean(comboModel, result);
        RedisUtil.putHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId, result);

        return ResUtil.success();
    }

    @Override
    public Res<?> deleteCommodityCombo(String commoditySkuId, String comboId) {

        Object result = RedisUtil.getHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId);

        if (result == null) {
            return ResUtil.error();
        }

        if (RedisUtil.removeHash(CACHE_COMMODITY_COMBO_PREFIX + commoditySkuId, comboId) <= 0) {
            return ResUtil.error();
        }

        return ResUtil.success();
    }

}
