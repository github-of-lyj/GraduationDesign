package lyj.controller;

import entities.Post;
import jakarta.annotation.Resource;
import lyj.service.ForumFeignService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getPost/{postID}")
    public Post selectPostByPostID(@PathVariable("postID") int postID){
        return forumService.selectPostByPostID(postID);
    }

    @GetMapping("/getUserPostNumber/{userName}")
    public int selectPostNumberByUserName(@PathVariable("userName") String userName){
        return forumService.selectPostNumberByUserName(userName);
    }

    @PostMapping("/insertNewPost")
    int insertNewPost(@RequestBody Post publishData){
        return forumService.insertNewPost(publishData);
    }
}
