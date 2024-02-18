package lyj.controller;

import entities.PostSearch;
import jakarta.annotation.Resource;
import lyj.service.SearchFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/PostSearch")
public class PostSearchController {
    @Resource
    SearchFeignService searchService;

    @GetMapping("/getPost/{searchField}")
    public List<PostSearch> selectVaguePost(@PathVariable("searchField") String searchField){
        return searchService.selectVaguePost(searchField);
    }

    @GetMapping("/selectUserPost/{userID}")
    List<PostSearch> selectUserPost(@PathVariable("userID")int userID){
        return searchService.selectUserPost(userID);
    }
}
