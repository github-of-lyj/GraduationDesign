package lyj.controller;

import entities.Post;
import jakarta.annotation.Resource;
import lyj.service.ManageFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/PostManage")
public class PostManageController {
    @Resource
    ManageFeignService manageFeignService;

    @GetMapping("/selectPost/{searchField}")
    List<Post> selectPost(@PathVariable("searchField") String searchField){
        return manageFeignService.selectPost(searchField);
    }
}
