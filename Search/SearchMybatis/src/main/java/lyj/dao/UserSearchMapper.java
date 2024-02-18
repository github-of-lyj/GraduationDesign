package lyj.dao;

import entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserSearchMapper {
    List<User> selectVagueUser(@Param("searchField")String searchField);

    User selectUser(@Param("userID")int userID);
}
