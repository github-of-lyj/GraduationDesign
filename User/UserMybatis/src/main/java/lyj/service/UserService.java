package lyj.service;

import entities.User;
import entities.request.User.userLoginRequest;
import entities.request.User.userRegisterRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    int userRegister(userRegisterRequest userRegister);

    User userLogin(userLoginRequest userLogin, HttpServletRequest request);

    void userLogOut(User user);

    Boolean checkUserLoginStatus(User user);

}
