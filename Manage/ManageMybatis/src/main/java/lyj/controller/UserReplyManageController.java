package lyj.controller;

import entities.UserReply;
import lyj.service.UserReplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
