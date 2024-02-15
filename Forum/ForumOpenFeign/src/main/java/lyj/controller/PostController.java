package lyj.controller;

import entities.Post;
import jakarta.annotation.Resource;
import lyj.service.ForumFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/post")
public class PostController {
    @Resource
    ForumFeignService forumService;

    @GetMapping("/getPosts/{blockID}")
    List<Post> selectPostsByBlockID(@PathVariable("blockID") int blockID){
        return forumService.selectPostsByBlockID(blockID);
    }
}
