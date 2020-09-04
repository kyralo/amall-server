package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbUserService;
import online.kyralo.amall.api.bo.TbUserBO;
import online.kyralo.amall.api.model.TbUserModel;
import online.kyralo.amall.common.annotation.NewCache;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.constants.CacheEnum;
import online.kyralo.amall.common.exceptions.business.UserException;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbUserDO;
import online.kyralo.amall.dao.mapper.TbUserDAO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static online.kyralo.amall.common.constants.RedisConstant.CACHE_TB_KEY_PREFIX;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserDAO tbUserDAO;

    private final BeanCopier copier = BeanCopier.create(TbUserModel.class, TbUserDO.class, false);

    @Transactional(readOnly = true)
    @NewCache(value = CACHE_TB_KEY_PREFIX + "user", key = "id", type = CacheEnum.QUERY)
    @Override
    public Res<?> findById(String id) {
        TbUserDO tbUserDO = tbUserDAO.findById(id);

        if (tbUserDO != null) {
            TbUserBO tbUser = new TbUserBO();
            CopyUtil.copyBean(tbUserDO, tbUser);
            return ResUtil.success(tbUser);
        }

        throw new UserException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbUserDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbUserModel tbUserModel) {

        TbUserDO tbUserDO = new TbUserDO();
        copier.copy(tbUserModel, tbUserDO, null);

        int i = tbUserDAO.insert(tbUserDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @NewCache(value = CACHE_TB_KEY_PREFIX + "user", key = "tbUserModel.id", type = CacheEnum.UPDATE)
    @Override
    public Res<?> update(TbUserModel tbUserModel) {

        TbUserDO tbUserDO = new TbUserDO();
        copier.copy(tbUserModel, tbUserDO, null);

        int i = tbUserDAO.updateByPrimaryKeySelective(tbUserDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Override
    @NewCache(value = CACHE_TB_KEY_PREFIX + "user", key = "id", type = CacheEnum.DELETE)
    public Res<?> deleteById(String id) {
        int i = tbUserDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new UserException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @NewCache(value = CACHE_TB_KEY_PREFIX + "user", key = "id", type = CacheEnum.QUERY)
    @Override
    public Res<?> queryById(String id) {
        TbUserDO tbUserDO = tbUserDAO.findById(id);
        TbUserBO tbUser = new TbUserBO();

        if (tbUserDO != null) {
            CopyUtil.copyBean(tbUserDO, tbUser);
        }

        return ResUtil.success(tbUser);
    }

}