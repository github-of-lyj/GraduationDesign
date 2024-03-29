package lyj.controller;

import entities.PostReply;
import lyj.service.PostReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postReply")
public class postReplyController {
    @Autowired
    PostReplyService postReplyDAO;

    @GetMapping("/getEarliestPostReplyFromPost/{postID}")
    public PostReply getEarliestPostReplyFromPost(@PathVariable("postID") int postID){
        return postReplyDAO.getEarliestPostReplyFromPost(postID);
    }

    @GetMapping("/getLatestPostReplyFromPost/{postID}")
    public PostReply getLatestPostReplyFromPost(@PathVariable("postID") int postID){
        return postReplyDAO.getLatestPostReplyFromPost(postID);
    }

    @GetMapping("/getAllReplyFromPost/{postID}")
    public List<PostReply> getAllReplyFromPost(@PathVariable("postID") int postID){
        return postReplyDAO.getAllReplyFromPost(postID);
    }

    @PostMapping("/insertNewPostReply")
    public int insertNewPostReply(@RequestBody PostReply postReply){
        return postReplyDAO.insertNewPostReply(postReply);
    }
}
