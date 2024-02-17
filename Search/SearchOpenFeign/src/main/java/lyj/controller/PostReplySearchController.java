package lyj.controller;

import entities.PostReplySearch;
import jakarta.annotation.Resource;
import lyj.service.SearchFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/PostReplySearch")
public class PostReplySearchController {
    @Resource
    SearchFeignService searchService;

    @GetMapping("/getPostReply/{searchField}")
    public List<PostReplySearch> selectVaguePostReply(@PathVariable("searchField") String searchField){
        return searchService.selectVaguePostReply(searchField);
    }
}
