package lyj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import entities.User;
import lyj.dao.UserManageMapper;
import lyj.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    UserManageMapper userManageDAO;

    @Override
    @DS("slave")
    public List<User> selectUser(String searchField) {
        return userManageDAO.selectUser(searchField);
    }

    @Override
    public void modifyUserAuthority(int userID, String authority) {
        userManageDAO.modifyUserAuthority(userID,authority);
    }
}
