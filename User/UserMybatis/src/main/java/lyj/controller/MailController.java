package lyj.controller;

import cn.hutool.core.util.RandomUtil;
import entities.request.User.userRegisterRequest;
import lyj.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping("/sendCode")
    public void sendVerifyCode(@RequestBody userRegisterRequest userRegisterData) {
        String userAccount = userRegisterData.getUserAccount();
        if (userAccount == null)
            return;
        String verifyCode = RandomUtil.randomString(6);
        mailService.sendSimpleMall(userAccount,"邮箱验证码——来自研墨",verifyCode);
        String key = userAccount + verifyCode;
        redisTemplate.opsForValue().set(key,verifyCode,60, TimeUnit.SECONDS);
    }
}
