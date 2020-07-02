package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbMerchantService;
import online.kyralo.amall.api.model.TbMerchantModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.MerchantException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbMerchantDO;
import online.kyralo.amall.dao.mapper.TbMerchantDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class TbMerchantServiceImpl implements TbMerchantService {

    @Resource
    private TbMerchantDAO tbMerchantDAO;

    private final BeanCopier copier = BeanCopier.create(TbMerchantModel.class, TbMerchantDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbMerchantDO tbMerchantDO = tbMerchantDAO.findById(id);

        if (tbMerchantDO != null) {
            TbMerchantModel tbMerchant = new TbMerchantModel();
            copier.copy(tbMerchantDO, tbMerchant, null);
            return ResUtil.success(tbMerchant);
        }

        throw new MerchantException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbMerchantDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbMerchantModel tbMerchantModel) {

        TbMerchantDO tbMerchantDO = new TbMerchantDO();
        copier.copy(tbMerchantModel, tbMerchantDO, null);

        int i = tbMerchantDAO.insert(tbMerchantDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new MerchantException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbMerchantModel tbMerchantModel) {

        TbMerchantDO tbMerchantDO = new TbMerchantDO();
        copier.copy(tbMerchantModel, tbMerchantDO, null);

        int i = tbMerchantDAO.update(tbMerchantDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new MerchantException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbMerchantDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new MerchantException(ResCode.FAILED);
    }

}