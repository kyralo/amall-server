package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbAdminService;
import online.kyralo.amall.api.bo.TbAdminBO;
import online.kyralo.amall.api.model.TbAdminModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.AdminException;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbAdminDO;
import online.kyralo.amall.dao.mapper.TbAdminDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbAdminServiceImpl implements TbAdminService {

    @Resource
    private TbAdminDAO tbAdminDAO;

    private final BeanCopier copier = BeanCopier.create(TbAdminModel.class, TbAdminDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbAdminDO tbAdminDO = tbAdminDAO.findById(id);

        if (tbAdminDO != null) {
            TbAdminBO tbAdmin = new TbAdminBO();
            CopyUtil.copyBean(tbAdminDO, tbAdmin);
            return ResUtil.success(tbAdmin);
        }

        throw new AdminException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbAdminDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbAdminModel tbAdminModel) {

        TbAdminDO tbAdminDO = new TbAdminDO();
        copier.copy(tbAdminModel, tbAdminDO, null);

        int i = tbAdminDAO.insert(tbAdminDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new AdminException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbAdminModel tbAdminModel) {

        TbAdminDO tbAdminDO = new TbAdminDO();
        copier.copy(tbAdminModel, tbAdminDO, null);

        int i = tbAdminDAO.updateByPrimaryKeySelective(tbAdminDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new AdminException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbAdminDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new AdminException(ResCode.FAILED);
    }

}