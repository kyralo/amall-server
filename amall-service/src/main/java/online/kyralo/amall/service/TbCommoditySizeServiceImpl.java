package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommoditySizeService;
import online.kyralo.amall.api.model.TbCommoditySizeModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommoditySizeDO;
import online.kyralo.amall.dao.mapper.TbCommoditySizeDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommoditySizeServiceImpl implements TbCommoditySizeService {

    @Resource
    private TbCommoditySizeDAO tbCommoditySizeDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommoditySizeModel.class, TbCommoditySizeDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(Integer id) {
        TbCommoditySizeDO tbCommoditySizeDO = tbCommoditySizeDAO.findById(id);

        if (tbCommoditySizeDO != null) {
            TbCommoditySizeModel tbCommoditySize = new TbCommoditySizeModel();
            copier.copy(tbCommoditySizeDO, tbCommoditySize, null);
            return ResUtil.success(tbCommoditySize);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommoditySizeDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommoditySizeModel tbCommoditySizeModel) {

        TbCommoditySizeDO tbCommoditySizeDO = new TbCommoditySizeDO();
        copier.copy(tbCommoditySizeModel, tbCommoditySizeDO, null);

        int i = tbCommoditySizeDAO.insert(tbCommoditySizeDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommoditySizeModel tbCommoditySizeModel) {

        TbCommoditySizeDO tbCommoditySizeDO = new TbCommoditySizeDO();
        copier.copy(tbCommoditySizeModel, tbCommoditySizeDO, null);

        int i = tbCommoditySizeDAO.update(tbCommoditySizeDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(Integer id) {
        int i = tbCommoditySizeDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

}