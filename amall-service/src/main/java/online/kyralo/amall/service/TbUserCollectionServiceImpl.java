package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbUserCollectionService;
import online.kyralo.amall.api.bo.TbUserCollectionBO;
import online.kyralo.amall.api.model.TbUserCollectionModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.UserException;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbUserCollectionDO;
import online.kyralo.amall.dao.mapper.TbUserCollectionDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserCollectionServiceImpl implements TbUserCollectionService {

    @Resource
    private TbUserCollectionDAO tbUserCollectionDAO;

    private final BeanCopier copier = BeanCopier.create(TbUserCollectionModel.class, TbUserCollectionDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(Integer id) {
        TbUserCollectionDO tbUserCollectionDO = tbUserCollectionDAO.findById(id);

        if (tbUserCollectionDO != null) {
            TbUserCollectionBO tbUserCollection = new TbUserCollectionBO();
            CopyUtil.copyBean(tbUserCollectionDO, tbUserCollection);
            return ResUtil.success(tbUserCollection);
        }

        throw new UserException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbUserCollectionDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbUserCollectionModel tbUserCollectionModel) {

        TbUserCollectionDO tbUserCollectionDO = new TbUserCollectionDO();
        copier.copy(tbUserCollectionModel, tbUserCollectionDO, null);

        int i = tbUserCollectionDAO.insert(tbUserCollectionDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbUserCollectionModel tbUserCollectionModel) {

        TbUserCollectionDO tbUserCollectionDO = new TbUserCollectionDO();
        copier.copy(tbUserCollectionModel, tbUserCollectionDO, null);

        int i = tbUserCollectionDAO.updateByPrimaryKeySelective(tbUserCollectionDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(Integer id) {
        int i = tbUserCollectionDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    public Res<?> countByUserId(String userId) {
        Example example = new Example(TbUserCollectionDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        int count = tbUserCollectionDAO.selectCountByExample(example);
        return ResUtil.success(count);
    }

}