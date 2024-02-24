package lyj.service;

import entities.UserReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserReplyManageService {
    List<UserReply> selectUserReply(String searchField);
}
