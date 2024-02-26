package lyj.controller;

import entities.UserReply;
import lyj.service.UserReplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserReplyManage")
public class UserReplyManageController {
    @Autowired
    UserReplyManageService userReplyManageService;

    @GetMapping("/selectUserReply/{searchField}")
    public List<UserReply> selectUserReply(@PathVariable("searchField") String searchField){
        return userReplyManageService.selectUserReply(searchField);
    }

    @PostMapping("/deleteUserReply/{userReplyID}")
    public void deleteUserReply(@PathVariable("userReplyID")int userReplyID){
        userReplyManageService.deleteUserReply(userReplyID);
    }
}
