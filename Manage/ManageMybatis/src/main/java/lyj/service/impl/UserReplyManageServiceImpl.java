package lyj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import entities.UserReply;
import lyj.dao.UserReplyManageMapper;
import lyj.service.UserReplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class UserReplyManageServiceImpl implements UserReplyManageService {
    @Autowired
    UserReplyManageMapper userReplyManageDAO;

    @Override
    @DS("slave")
    public List<UserReply> selectUserReply(String searchField) {
        return userReplyManageDAO.selectUserReply(searchField);
    }

    @Override
    public void deleteUserReply(int userReplyID) {
        userReplyManageDAO.deleteUserReply(userReplyID);
    }
}
