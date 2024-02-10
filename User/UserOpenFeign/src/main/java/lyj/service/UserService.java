package lyj.service;

import common.BaseResponse;
import entities.User;
import entities.request.User.userLoginRequest;
import entities.request.User.userRegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "user-mybatis")
public interface UserService {
    @PostMapping("/mail/sendCode")
    void sendVerifyCode(@RequestBody userRegisterRequest userRegisterData);

    @PostMapping("/user/register")
    BaseResponse<Integer> userRegister(@RequestBody userRegisterRequest userRegisterInfo);

    @PostMapping("/user/login")
    BaseResponse<User> userLogin(@RequestBody userLoginRequest userLoginInfo);

    @PostMapping("/user/checkLogin")
    void checkLogin(@RequestBody User userData);

    @PostMapping("/user/logout")
    void userLogout(@RequestBody User userData);
}
