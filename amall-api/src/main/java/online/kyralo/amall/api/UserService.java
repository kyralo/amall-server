package online.kyralo.amall.api;


import online.kyralo.amall.api.model.UserModel;

/**
 * @author wangchen
 */

public interface UserService {

    String getUserName(Long id);

    UserModel addUser(UserModel user);
}
