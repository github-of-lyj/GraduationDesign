package lyj.controller;

import common.SearchJudgeUtil;
import entities.PostSearch;
import lyj.service.PostSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/PostSearch")
public class PostSearchController {
    @Autowired
    PostSearchService postSearchDAO;

    @GetMapping("/getPost/{searchField}")
    public List<PostSearch> selectVaguePost(@PathVariable("searchField") String searchField){
        return postSearchDAO.selectVaguePost(searchField);
    }

    @GetMapping("/selectHotPost")
    public List<PostSearch> selectHotPost(){
        return postSearchDAO.selectHotPost();
    }

    @GetMapping("/selectUserPost/{userID}")
    public List<PostSearch> selectUserPost(@PathVariable("userID")int userID){
        return postSearchDAO.selectUserPost(userID);
    }


}
