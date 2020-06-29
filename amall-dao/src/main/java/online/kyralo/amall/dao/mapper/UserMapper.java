package online.kyralo.amall.dao.mapper;

import online.kyralo.amall.common.base.BaseDao;
import online.kyralo.amall.dao.dataobject.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author wangchen
 */

@Repository
public interface UserMapper extends BaseDao<UserDO> {

    UserDO getByName(String name);

    UserDO getById(Long id);

    @Override
    int insert(UserDO userDO);
}
