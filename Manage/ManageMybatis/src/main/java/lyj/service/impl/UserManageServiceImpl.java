package lyj.service.impl;

import entities.User;
import lyj.dao.UserManageMapper;
import lyj.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    UserManageMapper userManageDAO;

    @Override
    public List<User> selectUser(String searchField) {
        return userManageDAO.selectUser(searchField);
    }
}
