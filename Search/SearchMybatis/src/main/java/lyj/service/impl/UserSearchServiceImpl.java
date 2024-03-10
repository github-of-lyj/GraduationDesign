package lyj.service.impl;

import common.SearchJudgeUtil;
import entities.PostSearch;
import entities.User;
import lyj.dao.UserSearchMapper;
import lyj.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSearchServiceImpl implements UserSearchService {
    @Autowired
    UserSearchMapper userSearchDAO;

    @Override
    public List<User> selectVagueUser(String searchField) {
        List<User> users = userSearchDAO.selectVagueUser("");
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (SearchJudgeUtil.isContain(searchField,user.getUserName()))
                result.add(user);
        }
        return result;
    }

    @Override
    public User selectUser(int userID) {
        return userSearchDAO.selectUser(userID);
    }


}
