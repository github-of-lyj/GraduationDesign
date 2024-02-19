package lyj.controller;

import entities.UserReply;
import jakarta.annotation.Resource;
import lyj.service.ForumFeignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/userReply")
public class UserReplyController {
    @Resource
    ForumFeignService forumService;

    @GetMapping("/selectUserReplyCount/{postReplyID}")
    int selectUserReplyCount(@PathVariable("postReplyID") int postReplyID){
        return forumService.selectUserReplyCount(postReplyID);
    }

    @GetMapping("/selectAllUserReply/{postReplyID}")
    public List<UserReply> selectAllUserReply(@PathVariable("postReplyID")int postReplyID){
        return forumService.selectAllUserReply(postReplyID);
    }

    @PostMapping("/insertNewUserReply")
    public Object insertNewUserReply(@RequestBody UserReply userReply){
        return forumService.insertNewUserReply(userReply);
    }
}
