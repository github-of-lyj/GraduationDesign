package lyj.controller;

import entities.PostReply;
import jakarta.annotation.Resource;
import lyj.service.ForumFeignService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insertNewPostReply")
    Object insertNewPostReply(@RequestBody PostReply publishData){
        return forumService.insertNewPostReply(publishData);
    }

    @GetMapping("/getNewPostReplyList/{userID}")
    List getNewPostReplyList(@PathVariable("userID") int userID){
        return forumService.getNewPostReplyList(userID);
    }

    @PostMapping ("/delNewPostHis/{userID}/{postID}")
    void delNewPostHis(@PathVariable("userID")int userID,@PathVariable("postID") int postID){
        forumService.delNewPostHis(userID,postID);
    }
}
