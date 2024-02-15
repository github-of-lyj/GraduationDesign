package lyj.controller;

import entities.PostReply;
import jakarta.annotation.Resource;
import lyj.service.ForumFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/postReply")
public class PostReplyController {
    @Resource
    ForumFeignService forumService;

    @GetMapping("/getEarliestPostReplyFromPost/{postID}")
    PostReply getEarliestPostReplyFromPost(@PathVariable("postID") int postID){
        return forumService.getEarliestPostReplyFromPost(postID);
    }

    @GetMapping("/getLatestPostReplyFromPost/{postID}")
    PostReply getLatestPostReplyFromPost(@PathVariable("postID") int postID){
        return forumService.getLatestPostReplyFromPost(postID);
    }

    @GetMapping("/getAllReplyFromPost/{postID}")
    List<PostReply> getAllReplyFromPost(@PathVariable("postID") int postID){
        return forumService.getAllReplyFromPost(postID);
    }
}
