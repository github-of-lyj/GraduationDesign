package lyj.controller;

import entities.PostReply;
import jakarta.annotation.Resource;
import lyj.service.ManageFeignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/PostReplyManage")
public class PostReplyManageController {
    @Resource
    ManageFeignService manageFeignService;

    @GetMapping("/selectPostReply/{searchField}")
    public List<PostReply> selectPostReply(@PathVariable("searchField") String searchField){
        return manageFeignService.selectPostReply(searchField);
    }

    @PostMapping("/deletePostReply/{postReplyID}")
    public void deletePostReply(@PathVariable("postReplyID") int postReplyID){
        manageFeignService.deletePostReply(postReplyID);
    }
}
