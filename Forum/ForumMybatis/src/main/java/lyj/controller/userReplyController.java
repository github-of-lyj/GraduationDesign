package lyj.controller;

import entities.UserReply;
import lyj.service.UserReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userReply")
public class userReplyController {
    @Autowired
    UserReplyService userReplyDAO;


    @GetMapping("/selectUserReplyCount/{postReplyID}")
    public int selectUserReplyCount(@PathVariable("postReplyID") int postReplyID){
        return userReplyDAO.selectUserReplyCount(postReplyID);
    }

    @GetMapping("/selectAllUserReply/{postReplyID}")
    public List<UserReply> selectAllUserReply(@PathVariable("postReplyID")int postReplyID) {
        return userReplyDAO.selectAllUserReply(postReplyID);
    }

    @PostMapping("/insertNewUserReply")
    public int insertNewUserReply(@RequestBody UserReply userReply){
        return userReplyDAO.insertNewUserReply(userReply);
    }
}
