package lyj.controller;

import entities.PostReply;
import jakarta.annotation.Resource;
import lyj.service.ManageFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/PostReplyManage")
public class PostReplyManageController {
    @Resource
    ManageFeignService manageFeignService;

    @GetMapping("/selectPostReply/{searchField}")
    List<PostReply> selectPostReply(@PathVariable("searchField") String searchField){
        return manageFeignService.selectPostReply(searchField);
    }
}
