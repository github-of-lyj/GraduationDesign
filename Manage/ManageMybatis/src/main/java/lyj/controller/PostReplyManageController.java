package lyj.controller;

import entities.PostReply;
import lyj.service.PostReplyManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/deletePostReply/{postReplyID}")
    public void deletePostReply(@PathVariable("postReplyID") int postReplyID){
        postReplyManageService.deletePostReply(postReplyID);
    }
}
