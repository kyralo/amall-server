package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommoditySkuStockService;
import online.kyralo.amall.api.model.TbCommoditySkuStockModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommoditySkuStockDO;
import online.kyralo.amall.dao.mapper.TbCommoditySkuStockDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommoditySkuStockServiceImpl implements TbCommoditySkuStockService {

    @Resource
    private TbCommoditySkuStockDAO tbCommoditySkuStockDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommoditySkuStockModel.class, TbCommoditySkuStockDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(Integer id) {
        TbCommoditySkuStockDO tbCommoditySkuStockDO = tbCommoditySkuStockDAO.findById(id);

        if (tbCommoditySkuStockDO != null) {
            TbCommoditySkuStockModel tbCommoditySkuStock = new TbCommoditySkuStockModel();
            copier.copy(tbCommoditySkuStockDO, tbCommoditySkuStock, null);
            return ResUtil.success(tbCommoditySkuStock);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommoditySkuStockDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommoditySkuStockModel tbCommoditySkuStockModel) {

        TbCommoditySkuStockDO tbCommoditySkuStockDO = new TbCommoditySkuStockDO();
        copier.copy(tbCommoditySkuStockModel, tbCommoditySkuStockDO, null);

        int i = tbCommoditySkuStockDAO.insert(tbCommoditySkuStockDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommoditySkuStockModel tbCommoditySkuStockModel) {

        TbCommoditySkuStockDO tbCommoditySkuStockDO = new TbCommoditySkuStockDO();
        copier.copy(tbCommoditySkuStockModel, tbCommoditySkuStockDO, null);

        int i = tbCommoditySkuStockDAO.update(tbCommoditySkuStockDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);

    }

    @Override
    public Res<?> deleteById(Integer id) {
        int i = tbCommoditySkuStockDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

}