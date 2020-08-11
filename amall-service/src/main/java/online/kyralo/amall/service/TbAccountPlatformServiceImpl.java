package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbAccountPlatformService;
import online.kyralo.amall.api.model.TbAccountPlatformModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.UserException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbAccountPlatformDO;
import online.kyralo.amall.dao.mapper.TbAccountPlatformDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbAccountPlatformServiceImpl implements TbAccountPlatformService {

    @Resource
    private TbAccountPlatformDAO tbAccountPlatformDAO;

    private final BeanCopier copier = BeanCopier.create(TbAccountPlatformModel.class, TbAccountPlatformDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbAccountPlatformDO tbAccountPlatformDO = tbAccountPlatformDAO.findById(id);

        if (tbAccountPlatformDO != null) {
            TbAccountPlatformModel tbAccountPlatform = new TbAccountPlatformModel();
            copier.copy(tbAccountPlatformDO, tbAccountPlatform, null);
            return ResUtil.success(tbAccountPlatform);
        }

        throw new UserException(ResCode.NOT_FOUND);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbAccountPlatformDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbAccountPlatformModel tbAccountPlatformModel) {

        TbAccountPlatformDO tbAccountPlatformDO = new TbAccountPlatformDO();
        copier.copy(tbAccountPlatformModel, tbAccountPlatformDO, null);

        int i = tbAccountPlatformDAO.insert(tbAccountPlatformDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbAccountPlatformModel tbAccountPlatformModel) {

        TbAccountPlatformDO tbAccountPlatformDO = new TbAccountPlatformDO();
        copier.copy(tbAccountPlatformModel, tbAccountPlatformDO, null);

        int i = tbAccountPlatformDAO.updateByPrimaryKey(tbAccountPlatformDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbAccountPlatformDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new UserException(ResCode.FAILED);
    }

}