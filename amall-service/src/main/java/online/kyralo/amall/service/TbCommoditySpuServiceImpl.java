package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommoditySpuService;
import online.kyralo.amall.api.bo.TbCommoditySpuBO;
import online.kyralo.amall.api.model.TbCommoditySpuModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommoditySpuDO;
import online.kyralo.amall.dao.mapper.TbCommoditySpuDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommoditySpuServiceImpl implements TbCommoditySpuService {

    @Resource
    private TbCommoditySpuDAO tbCommoditySpuDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommoditySpuModel.class, TbCommoditySpuDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbCommoditySpuDO tbCommoditySpuDO = tbCommoditySpuDAO.findById(id);

        if (tbCommoditySpuDO != null) {
            TbCommoditySpuBO tbCommoditySpu = new TbCommoditySpuBO();
            CopyUtil.copyBean(tbCommoditySpuDO, tbCommoditySpu);
            return ResUtil.success(tbCommoditySpu);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommoditySpuDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommoditySpuModel tbCommoditySpuModel) {

        TbCommoditySpuDO tbCommoditySpuDO = new TbCommoditySpuDO();
        copier.copy(tbCommoditySpuModel, tbCommoditySpuDO, null);

        int i = tbCommoditySpuDAO.insert(tbCommoditySpuDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommoditySpuModel tbCommoditySpuModel) {

        TbCommoditySpuDO tbCommoditySpuDO = new TbCommoditySpuDO();
        copier.copy(tbCommoditySpuModel, tbCommoditySpuDO, null);

        int i = tbCommoditySpuDAO.updateByPrimaryKeySelective(tbCommoditySpuDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbCommoditySpuDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

}