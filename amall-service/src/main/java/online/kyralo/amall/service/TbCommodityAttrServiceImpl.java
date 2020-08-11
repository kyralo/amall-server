package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommodityAttrService;
import online.kyralo.amall.api.model.TbCommodityAttrModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommodityAttrDO;
import online.kyralo.amall.dao.mapper.TbCommodityAttrDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommodityAttrServiceImpl implements TbCommodityAttrService {

    @Resource
    private TbCommodityAttrDAO tbCommodityAttrDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommodityAttrModel.class, TbCommodityAttrDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbCommodityAttrDO tbCommodityAttrDO = tbCommodityAttrDAO.findById(id);

        if (tbCommodityAttrDO != null) {
            TbCommodityAttrModel tbCommodityAttr = new TbCommodityAttrModel();
            copier.copy(tbCommodityAttrDO, tbCommodityAttr, null);
            return ResUtil.success(tbCommodityAttr);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommodityAttrDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommodityAttrModel tbCommodityAttrModel) {

        TbCommodityAttrDO tbCommodityAttrDO = new TbCommodityAttrDO();
        copier.copy(tbCommodityAttrModel, tbCommodityAttrDO, null);

        int i = tbCommodityAttrDAO.insert(tbCommodityAttrDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommodityAttrModel tbCommodityAttrModel) {

        TbCommodityAttrDO tbCommodityAttrDO = new TbCommodityAttrDO();
        copier.copy(tbCommodityAttrModel, tbCommodityAttrDO, null);

        int i = tbCommodityAttrDAO.updateByPrimaryKey(tbCommodityAttrDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbCommodityAttrDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

}