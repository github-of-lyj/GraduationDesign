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

    public static String randomString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //发送邮件
    @PostMapping("/sendCode")
    public void sendVerifyCode(@RequestBody userRegisterRequest userRegisterData) {
        //从封装的注册用户对象中提取处要发送的目标邮箱地址
        String userAccount = userRegisterData.getUserAccount();
        if (userAccount == null)
            return;
        //生成包含大小写以及数字的六位验证码
        String verifyCode = RandomUtil.randomString(randomString,6);
        //发送邮箱
        mailService.sendSimpleMall(userAccount,"邮箱验证码——来自研墨",verifyCode + "——过期时间三分钟");
        //将相应的邮箱加上验证码作为存入 redis 的 key 以确保唯一性
        //同时设置相应的过期时间
        String key = userAccount + verifyCode;
        redisTemplate.opsForValue().set(key,verifyCode,180, TimeUnit.SECONDS);
    }
}
