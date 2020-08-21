package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbUserCommentService;
import online.kyralo.amall.api.bo.TbUserCommentBO;
import online.kyralo.amall.api.model.TbUserCommentModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.UserException;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbUserCommentDO;
import online.kyralo.amall.dao.mapper.TbUserCommentDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserCommentServiceImpl implements TbUserCommentService {

    @Resource
    private TbUserCommentDAO tbUserCommentDAO;

    private final BeanCopier copier = BeanCopier.create(TbUserCommentModel.class, TbUserCommentDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String id) {
        TbUserCommentDO tbUserCommentDO = tbUserCommentDAO.findById(id);

        if (tbUserCommentDO != null) {
            TbUserCommentBO tbUserComment = new TbUserCommentBO();
            CopyUtil.copyBean(tbUserCommentDO, tbUserComment);
            return ResUtil.success(tbUserComment);
        }

        throw new UserException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbUserCommentDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbUserCommentModel tbUserCommentModel) {

        TbUserCommentDO tbUserCommentDO = new TbUserCommentDO();
        copier.copy(tbUserCommentModel, tbUserCommentDO, null);

        int i = tbUserCommentDAO.insert(tbUserCommentDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbUserCommentModel tbUserCommentModel) {

        TbUserCommentDO tbUserCommentDO = new TbUserCommentDO();
        copier.copy(tbUserCommentModel, tbUserCommentDO, null);

        int i = tbUserCommentDAO.updateByPrimaryKeySelective(tbUserCommentDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(String id) {
        int i = tbUserCommentDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new UserException(ResCode.FAILED);
    }

}