package lyj.service.impl;

import entities.UserReply;
import lyj.dao.UserReplyManageMapper;
import lyj.service.UserReplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReplyManageServiceImpl implements UserReplyManageService {
    @Autowired
    UserReplyManageMapper userReplyManageDAO;

    @Override
    public List<UserReply> selectUserReply(String searchField) {
        return userReplyManageDAO.selectUserReply(searchField);
    }

    @Override
    public void deleteUserReply(int userReplyID) {
        userReplyManageDAO.deleteUserReply(userReplyID);
    }
}
