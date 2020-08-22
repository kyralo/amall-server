package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommoditySkuService;
import online.kyralo.amall.api.bo.TbCommoditySkuBO;
import online.kyralo.amall.api.model.TbCommoditySkuModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommoditySkuDO;
import online.kyralo.amall.dao.mapper.TbCommoditySkuDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommoditySkuServiceImpl implements TbCommoditySkuService {

    @Resource
    private TbCommoditySkuDAO tbCommoditySkuDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommoditySkuModel.class, TbCommoditySkuDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbCommoditySkuDO tbCommoditySkuDO = tbCommoditySkuDAO.findById(id);

        if (tbCommoditySkuDO != null) {
            TbCommoditySkuBO tbCommoditySku = new TbCommoditySkuBO();
            CopyUtil.copyBean(tbCommoditySkuDO, tbCommoditySku);
            return ResUtil.success(tbCommoditySku);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommoditySkuDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommoditySkuModel tbCommoditySkuModel) {

        TbCommoditySkuDO tbCommoditySkuDO = new TbCommoditySkuDO();
        copier.copy(tbCommoditySkuModel, tbCommoditySkuDO, null);

        int i = tbCommoditySkuDAO.insert(tbCommoditySkuDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommoditySkuModel tbCommoditySkuModel) {

        TbCommoditySkuDO tbCommoditySkuDO = new TbCommoditySkuDO();
        copier.copy(tbCommoditySkuModel, tbCommoditySkuDO, null);

        int i = tbCommoditySkuDAO.updateByPrimaryKeySelective(tbCommoditySkuDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbCommoditySkuDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }
}