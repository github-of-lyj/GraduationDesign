package lyj.controller;

import entities.User;
import lyj.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserSearch")
public class UserSearchController {
    @Autowired
    UserSearchService userSearchDAO;

    @GetMapping("/getUser/{searchField}")
    public List<User> selectVagueUser(@PathVariable("searchField") String searchField){
        return userSearchDAO.selectVagueUser(searchField);
    }

    @GetMapping("/selectUser/{userID}")
    public User selectUser(@PathVariable("userID") int userID){
        return userSearchDAO.selectUser(userID);
    }
}
