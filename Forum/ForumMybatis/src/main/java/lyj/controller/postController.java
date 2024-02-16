package lyj.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import entities.Post;
import lyj.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getPost/{postID}")
    public Post selectPostByPostID(@PathVariable("postID") int postID){
        return postDAO.selectPostByPostID(postID);
    }

    @GetMapping("/getUserPostNumber/{userName}")
    public int selectPostNumberByUserName(@PathVariable("userName") String userName){
        return postDAO.selectPostNumberByUserName(userName);
    }

    @PostMapping("/insertNewPost")
    public int insertNewPost(@RequestBody Post post){
        return postDAO.insertNewPost(post);
    }

}
