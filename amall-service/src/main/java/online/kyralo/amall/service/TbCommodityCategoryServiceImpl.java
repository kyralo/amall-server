package online.kyralo.amall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.kyralo.amall.api.TbCommodityCategoryService;
import online.kyralo.amall.api.model.TbCommodityCategoryModel;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.api.ResCode;
import online.kyralo.amall.common.exceptions.business.CommodityException;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.dao.dataobject.TbCommodityCategoryDO;
import online.kyralo.amall.dao.mapper.TbCommodityCategoryDAO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TbCommodityCategoryServiceImpl implements TbCommodityCategoryService {

    @Resource
    private TbCommodityCategoryDAO tbCommodityCategoryDAO;

    private final BeanCopier copier = BeanCopier.create(TbCommodityCategoryModel.class, TbCommodityCategoryDO.class, false);

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(Integer id) {
        TbCommodityCategoryDO tbCommodityCategoryDO = tbCommodityCategoryDAO.findById(id);

        if (tbCommodityCategoryDO != null) {
            TbCommodityCategoryModel tbCommodityCategory = new TbCommodityCategoryModel();
            copier.copy(tbCommodityCategoryDO, tbCommodityCategory, null);
            return ResUtil.success(tbCommodityCategory);
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return ResUtil.success(PageInfo.of(tbCommodityCategoryDAO.findByPage()));
    }

    @Override
    public Res<?> insert(TbCommodityCategoryModel tbCommodityCategoryModel) {

        TbCommodityCategoryDO tbCommodityCategoryDO = new TbCommodityCategoryDO();
        copier.copy(tbCommodityCategoryModel, tbCommodityCategoryDO, null);

        int i = tbCommodityCategoryDAO.insert(tbCommodityCategoryDO);
        if (i == 1) {
            return ResUtil.success("新增成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> update(TbCommodityCategoryModel tbCommodityCategoryModel) {

        TbCommodityCategoryDO tbCommodityCategoryDO = new TbCommodityCategoryDO();
        copier.copy(tbCommodityCategoryModel, tbCommodityCategoryDO, null);

        int i = tbCommodityCategoryDAO.updateByPrimaryKey(tbCommodityCategoryDO);

        if (i == 1) {
            return ResUtil.success("更新成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

    @Override
    public Res<?> deleteById(Integer id) {
        int i = tbCommodityCategoryDAO.deleteById(id);

        if (i == 1) {
            return ResUtil.success("删除成功");
        }

        throw new CommodityException(ResCode.FAILED);
    }

}