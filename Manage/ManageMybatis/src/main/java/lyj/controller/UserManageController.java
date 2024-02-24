package lyj.controller;

import entities.User;
import lyj.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserManage")
public class UserManageController {
    @Autowired
    UserManageService userManageService;


    @RequestMapping("/selectUser/{searchField}")
    public List<User> selectUser(@PathVariable("searchField") String searchField){
        return userManageService.selectUser(searchField);
    }
}
