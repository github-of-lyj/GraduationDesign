package lyj.controller;

import entities.PostReplySearch;
import lyj.service.PostReplySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PostReplySearch")
public class PostReplySearchController {
    @Autowired
    PostReplySearchService postReplySearchDAO;

    @GetMapping("/getPostReply/{searchField}")
    public List<PostReplySearch> selectVaguePostReply(@PathVariable("searchField") String searchField){
        return postReplySearchDAO.selectVaguePostReply(searchField);
    }

    @GetMapping("/selectPostReply/{userID}")
    public List<PostReplySearch> selectPostReply(@PathVariable("userID")int userID){
        return postReplySearchDAO.selectPostReply(userID);
    }

    @GetMapping("/selectHotPostReply")
    public List<PostReplySearch> selectHotPostReply(){
        return postReplySearchDAO.selectHotPostReply();
    }
}
