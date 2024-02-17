package lyj.service.impl;

import cn.hutool.core.date.DateUtil;
import entities.UserReply;
import lyj.dao.PostReplyMapper;
import lyj.dao.UserReplyMapper;
import lyj.service.UserReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReplyServiceImpl implements UserReplyService {
    @Autowired
    UserReplyMapper UserReplyDAO;

    @Autowired
    PostReplyMapper PostReplyDAO;

    @Override
    public int selectUserReplyCount(int postReplyID) {
        return UserReplyDAO.selectUserReplyCount(postReplyID);
    }

    @Override
    public List<UserReply> selectAllUserReply(int postReplyID) {
        return UserReplyDAO.selectAllUserReply(postReplyID);
    }

    @Override
    public int insertNewUserReply(UserReply userReply) {
        String userReplyTime = String.valueOf(DateUtil.date());
        userReply.setUserReplyTime(userReplyTime);
        UserReplyDAO.insertNewUserReply(userReply);
        PostReplyDAO.addPostReplyNumber(userReply.getPostID());
        return userReply.getUserReplyID();
    }
}
