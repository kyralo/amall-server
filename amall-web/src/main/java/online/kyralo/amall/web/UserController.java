package online.kyralo.amall.web;

import org.springframework.web.bind.annotation.*;

import online.kyralo.amall.api.UserService;
import online.kyralo.amall.api.model.UserModel;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/username")
    public String getUserName(@RequestParam("id") Long id) {
        return userService.getUserName(id);
    }

    @PostMapping("/add")
    public UserModel addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        UserModel user = new UserModel();
        user.setName(name);
        user.setAge(age);
        return userService.addUser(user);
    }
}
