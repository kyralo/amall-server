package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.TbUserCollectionDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户收藏
 */

@Repository
public interface TbUserCollectionDAO extends BaseDao<TbUserCollectionDO> {

    /**
     * 通过ID查询单个用户收藏
     *
     * @param id ID
     * @return {@link TbUserCollectionDO}
     */
    TbUserCollectionDO findById(Integer id);

    /**
     * 分页查询用户收藏
     *
     * @return {@link TbUserCollectionDO}
     */
    Page<TbUserCollectionDO> findByPage();

    /**
     * 新增用户收藏
     *
     * @param tbUserCollectionDO 用户收藏
     * @return 是否新增成功
     */
    @Override
    int insert(TbUserCollectionDO tbUserCollectionDO);

    /**
     * 通过ID删除单个用户收藏
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(Integer id);

    /**
     * 查询用户收藏 通过用户ID
     * @param userId 用户ID
     * @return 用户收藏
     */
    List<TbUserCollectionDO> listByUserId(String userId);

}