package lyj.controller;

import entities.User;
import jakarta.annotation.Resource;
import lyj.service.SearchFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/UserSearch")
public class UserSearchController {
    @Resource
    SearchFeignService searchService;

    @GetMapping("/getUser/{searchField}")
    public List<User> selectVagueUser(@PathVariable("searchField") String searchField){
        return searchService.selectVagueUser(searchField);
    }

    @GetMapping("/selectUser/{userID}")
    public User selectUser(@PathVariable("userID") int userID){
        return searchService.selectUser(userID);
    }
}
