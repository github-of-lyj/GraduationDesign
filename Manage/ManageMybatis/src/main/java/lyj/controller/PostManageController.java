package lyj.controller;

import entities.Post;
import lyj.service.PostManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PostManage")
public class PostManageController {

    @Autowired
    PostManageService postManageService;

    @GetMapping("/selectPost/{searchField}")
    public List<Post> selectPost(@PathVariable("searchField") String searchField){
        return postManageService.selectPost(searchField);
    }

    @PostMapping("/deletePost/{postID}")
    public void deletePost(@PathVariable("postID") int postID){
        postManageService.deletePost(postID);
    }
}
