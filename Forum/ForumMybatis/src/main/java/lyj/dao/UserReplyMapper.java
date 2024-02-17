package lyj.dao;

import entities.UserReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserReplyMapper {
    int selectUserReplyCount(@Param("postReplyID")int postReplyID);

    List<UserReply> selectAllUserReply(@Param("postReplyID")int postReplyID);

    int insertNewUserReply(@Param("userReply")UserReply userReply);
}
