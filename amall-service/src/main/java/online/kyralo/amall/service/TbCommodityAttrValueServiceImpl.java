package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommodityAttrValueService;
import online.kyralo.amall.api.model.TbCommodityAttrValueModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommodityAttrValueDO;
import online.kyralo.amall.dao.mapper.TbCommodityAttrValueDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommodityAttrValueServiceImpl implements TbCommodityAttrValueService {

    @Resource
    private TbCommodityAttrValueDAO tbCommodityAttrValueDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommodityAttrValueModel.class, TbCommodityAttrValueDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbCommodityAttrValueDO tbCommodityAttrValueDO = tbCommodityAttrValueDAO.findById(id);

        if (tbCommodityAttrValueDO != null) {
            TbCommodityAttrValueModel tbCommodityAttrValue = new TbCommodityAttrValueModel();
            copier.copy(tbCommodityAttrValueDO, tbCommodityAttrValue, null);
            return ResUtil.success(tbCommodityAttrValue);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommodityAttrValueDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommodityAttrValueModel tbCommodityAttrValueModel) {

        TbCommodityAttrValueDO tbCommodityAttrValueDO = new TbCommodityAttrValueDO();
        copier.copy(tbCommodityAttrValueModel, tbCommodityAttrValueDO, null);

        int i = tbCommodityAttrValueDAO.insert(tbCommodityAttrValueDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommodityAttrValueModel tbCommodityAttrValueModel) {

        TbCommodityAttrValueDO tbCommodityAttrValueDO = new TbCommodityAttrValueDO();
        copier.copy(tbCommodityAttrValueModel, tbCommodityAttrValueDO, null);

        int i = tbCommodityAttrValueDAO.update(tbCommodityAttrValueDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbCommodityAttrValueDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

}