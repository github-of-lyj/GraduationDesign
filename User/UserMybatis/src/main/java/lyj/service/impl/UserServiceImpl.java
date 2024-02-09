package lyj.service.impl;

import common.ConstantUtil;
import common.ErrorCode;
import entities.User;
import entities.request.User.userLoginRequest;
import entities.request.User.userRegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lyj.dao.UserMappper;
import lyj.exception.BusinessException;
import lyj.service.MailService;
import lyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMappper userDAO;

    @Autowired
    MailService mailService;

    @Autowired
    StringRedisTemplate redisTemplate;

    private static final String SALT = "YANMO";

    //静态方法 封装生成 User 对象
    public static User createNewUser(userRegisterRequest userRegister){
        User user = new User();
        String userName = userRegister.getUserName();
        String userAccount = userRegister.getUserAccount();
        String userPassword = userRegister.getUserPassword();
        user.setUserName(userName);
        user.setUserLevel(1);
        user.setUserAvatar(1);
        user.setUserExperience(0);
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setAuthority("1,2");
        user.setAdministrators(false);
        return user;
    }

    //实现用户注册的相关方法
    @Override
    public int userRegister(userRegisterRequest userRegister) {
        String userName = userRegister.getUserName();
        String userAccount = userRegister.getUserAccount();
        String userPassword = userRegister.getUserPassword();
        String verifyCode = userRegister.getVerifyCode();
        //从 redis 中获取验证码，若能够获取到相应的条目，说明验证码正确
        String verifyResult = redisTemplate.opsForValue().get(userAccount + verifyCode);
        if (verifyResult == null)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "验证码错误");
        //从数据库中查看是否存在重复的用户名，若存在，抛出异常
        if (userDAO.isExistSameUserName(userName) > 0)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名重复");
        //检查是否存在已经注册过的邮箱，若存在，抛出异常
        if (userDAO.isExistSameUserAccount(userAccount) > 0)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "邮箱已注册");
        //检验通过，将用户的密码加盐用 md5 加密后存储到数据库当中
        String encryption_userPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        userRegister.setUserPassword(encryption_userPassword);
        User newUser = createNewUser(userRegister);
        //注册后返回相应新建用户的 userID
        userDAO.createNewUser(newUser);
        return newUser.getUserID();
    }

    @Override
    public User userLogin(userLoginRequest userLogin, HttpServletRequest request) {
        String userPassword = userLogin.getUserPassword();
        String encryption_userPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        userLogin.setUserPassword(encryption_userPassword);
        User user = userDAO.isExistUser(userLogin);
        if (user == null)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        user.setUserPassword("");
        HttpSession session = request.getSession();
        session.setAttribute(user.getUserID() + user.getUserName(),user);
        redisTemplate.opsForValue().set(user.getUserID() + user.getUserName(),session.getId(),180, TimeUnit.SECONDS);
        return user;
    }

    @Override
    public void userLogOut(User user) {
        String key = user.getUserID() + user.getUserName();
        String sessionID = redisTemplate.opsForValue().get(key);
        if (sessionID == null)
            return;
        redisTemplate.delete(key);
        redisTemplate.opsForHash().delete(ConstantUtil.SPRING_SESSION_PREFIX + sessionID
                ,ConstantUtil.SPRING_SESSION_KEY_PREFIX + key);
    }

    @Override
    public Boolean checkUserLoginStatus(User checkUser) {
        int userID = checkUser.getUserID();
        int result = userDAO.isExistUserID(userID);
        if (result == 0)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "未知的用户");
        String key = checkUser.getUserID() + checkUser.getUserName();
        String sessionID = redisTemplate.opsForValue().get(key);
        Object o = redisTemplate.opsForHash().get(ConstantUtil.SPRING_SESSION_PREFIX + sessionID, ConstantUtil.SPRING_SESSION_KEY_PREFIX + key);
        return sessionID != null & o != null;
    }
}
