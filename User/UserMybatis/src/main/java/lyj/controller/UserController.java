package lyj.controller;

import common.BaseResponse;
import common.ResultUtils;
import entities.User;
import entities.request.User.userLoginRequest;
import entities.request.User.userRegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import lyj.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void checkLogin(@RequestBody User userData){
        userService.checkUserLoginStatus(userData);
    }

    @PostMapping("/logout")
    public void userLogout(@RequestBody User userData,HttpServletRequest httpServletRequest){
        userService.userLogOut(userData,httpServletRequest);
    }

    @GetMapping("/getUserName/{userID}")
    String getUserNameByUserID(@PathVariable("userID") int userID){
        return userService.getUserNameByUserID(userID);
    }

    @GetMapping("/getUser/{userName}")
    User getUserByUserName(@PathVariable("userName")String userName){
        User user = userService.getUserByUserName(userName);
        user.setUserPassword("");
        return user;
    }

    @PostMapping("/updateUserName/{userName}/{userID}")
    public void updateUserName(@PathVariable(value = "userName") String userName,@PathVariable(value = "userID") int userID) {
        userService.updateUserName(userName,userID);
    }

    @PostMapping("/updateUserDescription/{userDescription}/{userID}")
    public void updateUserDescription(@PathVariable(value = "userDescription") String userDescription,@PathVariable(value = "userID") int userID) {
        userService.updateUserDescription(userDescription,userID);
    }

    @PostMapping("/updateUserAvatar/{userID}/{fileID}")
    void updateUserAvatar(@PathVariable("userID")int userID, @PathVariable("fileID")int fileID){
        userService.updateUserAvatar(userID,fileID);
    }

}
