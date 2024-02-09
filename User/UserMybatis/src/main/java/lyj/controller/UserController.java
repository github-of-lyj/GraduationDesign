package lyj.controller;

import common.BaseResponse;
import common.ResultUtils;
import entities.User;
import entities.request.User.userLoginRequest;
import entities.request.User.userRegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import lyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/register")
    public BaseResponse<Integer> userRegister(@RequestBody userRegisterRequest userRegisterInfo){
        int userID = userService.userRegister(userRegisterInfo);
        return ResultUtils.success(userID);
    }

    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody userLoginRequest userLoginInfo, HttpServletRequest httpServletRequest){
        User user = userService.userLogin(userLoginInfo, httpServletRequest);
        return ResultUtils.success(user);
    }

    @PostMapping("/checkLogin")
    public Boolean checkLogin(@RequestBody User userData){
        return userService.checkUserLoginStatus(userData);
    }

    @PostMapping("/logout")
    public void userLogout(@RequestBody User userData){
        userService.userLogOut(userData);
    }

}
