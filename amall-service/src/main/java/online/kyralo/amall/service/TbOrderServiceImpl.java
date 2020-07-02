package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbOrderService;
import online.kyralo.amall.api.model.TbOrderModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.OrderException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbOrderDO;
import online.kyralo.amall.dao.mapper.TbOrderDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class TbOrderServiceImpl implements TbOrderService {

    @Resource
    private TbOrderDAO tbOrderDAO;

    private final BeanCopier copier = BeanCopier.create(TbOrderModel.class, TbOrderDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(Integer id) {
        TbOrderDO tbOrderDO = tbOrderDAO.findById(id);

        if (tbOrderDO != null) {
            TbOrderModel tbOrder = new TbOrderModel();
            copier.copy(tbOrderDO, tbOrder, null);
            return ResUtil.success(tbOrder);
        }

        throw new OrderException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbOrderDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbOrderModel tbOrderModel) {

        TbOrderDO tbOrderDO = new TbOrderDO();
        copier.copy(tbOrderModel, tbOrderDO, null);

        int i = tbOrderDAO.insert(tbOrderDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }
        throw new OrderException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbOrderModel tbOrderModel) {

        TbOrderDO tbOrderDO = new TbOrderDO();
        copier.copy(tbOrderModel, tbOrderDO, null);

        int i = tbOrderDAO.update(tbOrderDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new OrderException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(Integer id) {
        int i = tbOrderDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new OrderException(ResCode.FAILED);
    }

}