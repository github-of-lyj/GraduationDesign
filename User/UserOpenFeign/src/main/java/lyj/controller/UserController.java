package lyj.controller;

import common.BaseResponse;
import entities.User;
import entities.request.User.userLoginRequest;
import entities.request.User.userRegisterRequest;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lyj.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    BaseResponse<Integer> userRegister(@RequestBody userRegisterRequest userRegisterInfo){
        return userService.userRegister(userRegisterInfo);
    }

    @PostMapping("/login")
    BaseResponse<User> userLogin(@RequestBody userLoginRequest userLoginInfo){
        return userService.userLogin(userLoginInfo);
    }

    @PostMapping("/checkLogin")
    void checkLogin(@RequestBody User userData){
        userService.checkLogin(userData);
    }

    @PostMapping("/logout")
    void userLogout(@RequestBody User userData){
        userService.userLogout(userData);
    }
}
