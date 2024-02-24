package lyj.dao;

import entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserManageMapper {
    List<User> selectUser(@Param("searchField")String searchField);


}
