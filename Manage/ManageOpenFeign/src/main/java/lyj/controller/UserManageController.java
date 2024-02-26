package lyj.controller;

import entities.User;
import jakarta.annotation.Resource;
import lyj.service.ManageFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/UserManage")
public class UserManageController {
    @Resource
    ManageFeignService manageFeignService;

    @RequestMapping("/selectUser/{searchField}")
    public List<User> selectUser(@PathVariable("searchField") String searchField){
        return manageFeignService.selectUser(searchField);
    }

    @PostMapping("/modifyUserAuthority/{userID}/{authority}")
    public void modifyUserAuthority(@PathVariable("userID") int userID,@PathVariable("authority") String authority){
        manageFeignService.modifyUserAuthority(userID,authority);
    }
}
