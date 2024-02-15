package lyj.dao;

import entities.User;
import entities.request.User.userLoginRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMappper {
    int isExistSameUserName(@Param("userName")String userName);

    int isExistSameUserAccount(@Param("userAccount")String userAccount);

    int isExistUserID(@Param("userID")int userID);

    User isExistUser(@Param("userLoginRequest")userLoginRequest userLoginRequest);

    int createNewUser(@Param("User")User user);

    String getUserNameByUserID(@Param("userID")int userID);

    void updateUserName(@Param("userName")String userName,@Param("userID")int userID);

    void updateUserDescription(@Param("userDescription")String userDescription,@Param("userID")int userID);

    void updateUserAvatar(@Param("userID")int userID,@Param("fileID")int fileID);
}
