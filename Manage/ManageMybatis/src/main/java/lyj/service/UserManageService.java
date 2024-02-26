package lyj.service;

import entities.Post;
import entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserManageService {
    List<User> selectUser(String searchField);

    void modifyUserAuthority(int userID,String authority);
}
