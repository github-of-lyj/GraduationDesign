package lyj.service.impl;

import entities.User;
import lyj.dao.UserSearchMapper;
import lyj.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchServiceImpl implements UserSearchService {
    @Autowired
    UserSearchMapper userSearchDAO;

    @Override
    public List<User> selectVagueUser(String searchField) {
        return userSearchDAO.selectVagueUser(searchField);
    }

    @Override
    public User selectUser(int userID) {
        return userSearchDAO.selectUser(userID);
    }


}
