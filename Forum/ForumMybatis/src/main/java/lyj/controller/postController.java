package lyj.controller;

import entities.Post;
import lyj.dao.PostMapper;
import lyj.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class postController {
    @Autowired
    PostService postDAO;

    @GetMapping("/getPosts/{blockID}")
    public List<Post> selectPostsByBlockID(@PathVariable("blockID") int blockID){
        return postDAO.selectPostsByBlockID(blockID);
    }
}
