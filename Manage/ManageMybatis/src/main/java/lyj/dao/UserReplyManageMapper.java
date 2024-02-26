package lyj.dao;

import entities.UserReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserReplyManageMapper {
    List<UserReply> selectUserReply(@Param("searchField")String searchField);

    void deleteUserReply(@Param("userReplyID")int userReplyID);
}
