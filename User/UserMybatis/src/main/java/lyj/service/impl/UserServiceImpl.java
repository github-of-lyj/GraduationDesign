package lyj.service.impl;

import cn.hutool.core.util.RandomUtil;
import lyj.dao.UserMappper;
import lyj.service.MailService;
import lyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMappper userDAO;

    @Autowired
    MailService mailService;

    @Autowired
    StringRedisTemplate redisTemplate;


    @Override
    public int userRegister(String userName, String userAccount, String userPassword, String verifyCode) {
        String string = RandomUtil.randomString(6);


        return 0;
    }


}
