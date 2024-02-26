package lyj.controller;

import entities.Post;
import jakarta.annotation.Resource;
import lyj.service.ManageFeignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/PostManage")
public class PostManageController {
    @Resource
    ManageFeignService manageFeignService;

    @GetMapping("/selectPost/{searchField}")
    List<Post> selectPost(@PathVariable("searchField") String searchField){
        return manageFeignService.selectPost(searchField);
    }

    @PostMapping("/deletePost/{postID}")
    public void deletePost(@PathVariable("postID") int postID){
        manageFeignService.deletePost(postID);
    }
}
