package lyj.controller;

import entities.PostReply;
import lyj.service.PostReplyManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PostReplyManage")
public class PostReplyManageController {
    @Autowired
    PostReplyManageService postReplyManageService;

    @GetMapping("/selectPostReply/{searchField}")
    List<PostReply> selectPostReply(@PathVariable("searchField") String searchField){
        return postReplyManageService.selectPostReply(searchField);
    }
}
