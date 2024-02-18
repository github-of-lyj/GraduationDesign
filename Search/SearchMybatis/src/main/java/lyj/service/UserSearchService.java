package lyj.service;

import entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSearchService {
    List<User> selectVagueUser(String searchField);

    User selectUser(int userID);
}
