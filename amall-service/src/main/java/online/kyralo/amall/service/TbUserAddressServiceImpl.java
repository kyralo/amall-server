package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbUserAddressService;
import online.kyralo.amall.api.bo.TbUserAddressBO;
import online.kyralo.amall.api.model.TbUserAddressModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.UserException;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbUserAddressDO;
import online.kyralo.amall.dao.mapper.TbUserAddressDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserAddressServiceImpl implements TbUserAddressService {

    @Resource
    private TbUserAddressDAO tbUserAddressDAO;

    private final BeanCopier copier = BeanCopier.create(TbUserAddressModel.class, TbUserAddressDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(Integer id) {
        TbUserAddressDO tbUserAddressDO = tbUserAddressDAO.findById(id);

        if (tbUserAddressDO != null) {
            TbUserAddressBO tbUserAddress = new TbUserAddressBO();
            CopyUtil.copyBean(tbUserAddressDO, tbUserAddress);
            return ResUtil.success(tbUserAddress);
        }

        throw new UserException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbUserAddressDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbUserAddressModel tbUserAddressModel) {

        TbUserAddressDO tbUserAddressDO = new TbUserAddressDO();
        copier.copy(tbUserAddressModel, tbUserAddressDO, null);

        int i = tbUserAddressDAO.insert(tbUserAddressDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbUserAddressModel tbUserAddressModel) {

        TbUserAddressDO tbUserAddressDO = new TbUserAddressDO();
        copier.copy(tbUserAddressModel, tbUserAddressDO, null);

        int i = tbUserAddressDAO.updateByPrimaryKeySelective(tbUserAddressDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(Integer id) {
        int i = tbUserAddressDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new UserException(ResCode.FAILED);
    }

}