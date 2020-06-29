package online.kyralo.amall.service;

import org.springframework.cglib.beans.BeanCopier;

import online.kyralo.amall.dao.dataobject.UserDO;
import online.kyralo.amall.dao.mapper.UserMapper;
import online.kyralo.amall.api.UserService;
import online.kyralo.amall.api.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangchen
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    private final BeanCopier copier = BeanCopier.create(UserModel.class, UserDO.class, false);

    @Override
    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        return userDO != null ? userDO.getName() : null;
    }

    @Override
    public UserModel addUser(UserModel user) {
        UserDO userDO = new UserDO();
        copier.copy(user, userDO, null);

        int id = userMapper.insert(userDO);
        user.setId(id);
        return user;
    }
}
