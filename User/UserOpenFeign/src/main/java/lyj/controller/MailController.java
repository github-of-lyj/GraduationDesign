package lyj.controller;

import entities.request.User.userRegisterRequest;
import jakarta.annotation.Resource;
import lyj.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/mail")
public class MailController {
    @Resource
    private UserService userService;

    @PostMapping("/sendCode")
    void sendVerifyCode(@RequestBody userRegisterRequest userRegisterData){
        userService.sendVerifyCode(userRegisterData);
    }


}
