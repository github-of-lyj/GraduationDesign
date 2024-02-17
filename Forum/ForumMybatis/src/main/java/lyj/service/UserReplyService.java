package lyj.service;

import entities.UserReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserReplyService {
    int selectUserReplyCount(int postReplyID);

    List<UserReply> selectAllUserReply(int postReplyID);

    int insertNewUserReply(UserReply userReply);
}
