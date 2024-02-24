package lyj.controller;

import entities.Post;
import lyj.service.PostManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PostManage")
public class PostManageController {

    @Autowired
    PostManageService postManageService;

    @GetMapping("/selectPost/{searchField}")
    public List<Post> selectPost(@PathVariable("searchField") String searchField){
        return postManageService.selectPost(searchField);
    }
}
