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
import java.util.Objects;
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
        user.setUserDescription("这个人很懒，什么都没有留下");
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
        String key = user.getUserID() + user.getUserName();
        //获取到当前会话以及当前会话ID
        HttpSession session = request.getSession();
        String sessionID = redisTemplate.opsForValue().get(key);
        //若获取到的 sessionID不为空，说明先前已经有用户登录了
        //根据获取到的 sessionID，将先前登录用户的登录状态删除
        if (sessionID != null)
            redisTemplate.opsForHash().delete(
                    ConstantUtil.SPRING_SESSION_PREFIX + sessionID,
                    ConstantUtil.SPRING_SESSION_KEY_PREFIX + ConstantUtil.USER_LOGIN_STATUS
                    );
        //存储本会话的用户登录信息
        session.setAttribute(ConstantUtil.USER_LOGIN_STATUS,user);
        redisTemplate.opsForValue().set(key,session.getId(),1800, TimeUnit.SECONDS);
        user.setUniqueMark(session.getId());
        return user;
    }

    @Override
    public void userLogOut(User user,HttpServletRequest httpServletRequest) {
        //获取当前用户的会话信息
        HttpSession session = httpServletRequest.getSession();
        //获取相应的 key 并得到 sessionID
        String key = user.getUserID() + user.getUserName();
        String sessionID = redisTemplate.opsForValue().get(key);
        //sessionID为空，表明用户实际并未登录，是非法操作
        if (sessionID == null)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户未登录");
        //删除在 redis 中对于相应 sessionID 的存储，移除相应 session 中存放的用户登录状态
        redisTemplate.delete(key);
        session.removeAttribute(ConstantUtil.USER_LOGIN_STATUS);
    }

    @Override
    public void checkUserLoginStatus(User checkUser) {
        //确认当前传入的用户是否是本身存在的用户
        if (userDAO.isExistUserID(checkUser.getUserID()) == 0)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "未知的用户");
        if (userDAO.isExistSameUserName(checkUser.getUserName()) == 0)
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"不存在的用户名");
        if (userDAO.isExistSameUserAccount(checkUser.getUserAccount()) == 0)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "不存在的邮箱");
        String key = checkUser.getUserID() + checkUser.getUserName();
        String sessionID = redisTemplate.opsForValue().get(key);
        //说明当前账号没有用户登录，即用户登录已过期或先前有用户退出了登录.

        if (sessionID == null)
            throw new BusinessException(ErrorCode.USER_ERROR,"登录账户已过期");
        //获取到的 sessionID 不为空，但是当前的会话当中存储的用户登录状态为空（即先前获取到的 sessionID 已经不是原本会话的 SessionID)
        //这说明该账号在另一个会话下被登，该会话的登录状态已经被删除
        Object o = redisTemplate.opsForHash().get(
                ConstantUtil.SPRING_SESSION_PREFIX + checkUser.getUniqueMark(),
                ConstantUtil.SPRING_SESSION_KEY_PREFIX + ConstantUtil.USER_LOGIN_STATUS);
        if (o == null)
            throw new BusinessException(ErrorCode.USER_ERROR,"账号异地登录");
    }

    @Override
    public String getUserNameByUserID(int userID) {
        return userDAO.getUserNameByUserID(userID);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDAO.getUserByUserName(userName);
    }

    @Override
    public void updateUserName(String userName, int userID) {
        //从数据库中查看是否存在重复的用户名，若存在，抛出异常
        if (userDAO.isExistSameUserName(userName) > 0)
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名重复");
        userDAO.updateUserName(userName,userID);
    }

    @Override
    public void updateUserDescription(String userDescription, int userID) {
        System.out.println(userDescription);
        userDAO.updateUserDescription(userDescription,userID);
    }

    @Override
    public void updateUserAvatar(int userID, int fileID) {
        userDAO.updateUserAvatar(userID,fileID);
    }
}

