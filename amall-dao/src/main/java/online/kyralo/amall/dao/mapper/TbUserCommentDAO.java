package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import online.kyralo.amall.dao.dataobject.TbUserCommentDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户评论
 */

@Repository
public interface TbUserCommentDAO extends Mapper<TbUserCommentDO> {

    /**
     * 通过ID查询单个用户评论
     *
     * @param id ID
     * @return {@link TbUserCommentDO}
     */
    TbUserCommentDO findById(String id);

    /**
     * 分页查询用户评论
     *
     * @return {@link TbUserCommentDO}
     */
    Page<TbUserCommentDO> findByPage();

    /**
     * 新增用户评论
     *
     * @param tbUserCommentDO 用户评论
     * @return 是否新增成功
     */
    @Override
    int insert(TbUserCommentDO tbUserCommentDO);

    /**
     * 通过ID删除单个用户评论
     *
     * @param id ID
     * @return 是否删除成功
     */
    int deleteById(String id);

}