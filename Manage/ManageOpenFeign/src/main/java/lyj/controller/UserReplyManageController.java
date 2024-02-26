package lyj.controller;

import entities.UserReply;
import jakarta.annotation.Resource;
import lyj.service.ManageFeignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/UserReplyManage")
public class UserReplyManageController {
    @Resource
    ManageFeignService manageFeignService;

    @GetMapping("/selectUserReply/{searchField}")
    List<UserReply> selectUserReply(@PathVariable("searchField") String searchField){
        return manageFeignService.selectUserReply(searchField);
    }

    @PostMapping("/deleteUserReply/{userReplyID}")
    void deleteUserReply(@PathVariable("userReplyID")int userReplyID){
        manageFeignService.deleteUserReply(userReplyID);
    }
}
