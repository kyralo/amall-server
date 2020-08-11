package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommodityBrandsService;
import online.kyralo.amall.api.model.TbCommodityBrandsModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommodityBrandsDO;
import online.kyralo.amall.dao.mapper.TbCommodityBrandsDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommodityBrandsServiceImpl implements TbCommodityBrandsService {

    @Resource
    private TbCommodityBrandsDAO tbCommodityBrandsDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommodityBrandsModel.class, TbCommodityBrandsDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbCommodityBrandsDO tbCommodityBrandsDO = tbCommodityBrandsDAO.findById(id);

        if (tbCommodityBrandsDO != null) {
            TbCommodityBrandsModel tbCommodityBrands = new TbCommodityBrandsModel();
            copier.copy(tbCommodityBrandsDO, tbCommodityBrands, null);
            return ResUtil.success(tbCommodityBrands);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommodityBrandsDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommodityBrandsModel tbCommodityBrandsModel) {

        TbCommodityBrandsDO tbCommodityBrandsDO = new TbCommodityBrandsDO();
        copier.copy(tbCommodityBrandsModel, tbCommodityBrandsDO, null);

        int i = tbCommodityBrandsDAO.insert(tbCommodityBrandsDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommodityBrandsModel tbCommodityBrandsModel) {

        TbCommodityBrandsDO tbCommodityBrandsDO = new TbCommodityBrandsDO();
        copier.copy(tbCommodityBrandsModel, tbCommodityBrandsDO, null);

        int i = tbCommodityBrandsDAO.updateByPrimaryKey(tbCommodityBrandsDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbCommodityBrandsDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

}