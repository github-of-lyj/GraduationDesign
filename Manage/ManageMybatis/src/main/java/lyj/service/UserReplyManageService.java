package lyj.service;

import entities.UserReply;

import java.util.List;

public interface UserReplyManageService {
    List<UserReply> selectUserReply(String searchField);

    void deleteUserReply(int userReplyID);
}
