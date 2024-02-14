package lyj.service;

import entities.User;
import entities.request.User.userLoginRequest;
import entities.request.User.userRegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    int userRegister(userRegisterRequest userRegister);

    User userLogin(userLoginRequest userLogin, HttpServletRequest request);

    void userLogOut(User user,HttpServletRequest httpServletRequest);

    void checkUserLoginStatus(User user);

    void updateUserName(String userName, int userID);

    void updateUserDescription(String userDescription,int userID);

    void updateUserAvatar(int userID,int fileID);

}
