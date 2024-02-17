package lyj.service;

import entities.Block;
import entities.Post;
import entities.PostReply;
import entities.UserReply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(value = "forum-mybatis")
public interface ForumFeignService {
    @GetMapping("/block/getAll")
    List<Block> getAllBlock();

    @GetMapping("/block/get/{blockID}")
    Block selectBlockByID(@PathVariable("blockID")int blockID);

    @GetMapping("/post/getPosts/{blockID}")
    List<Post> selectPostsByBlockID(@PathVariable("blockID") int blockID);

    @GetMapping("/post/getPost/{postID}")
    Post selectPostByPostID(@PathVariable("postID") int postID);

    @GetMapping("/post/getUserPostNumber/{userName}")
    int selectPostNumberByUserName(@PathVariable("userName") String userName);

    @PostMapping("/post/insertNewPost")
    int insertNewPost(@RequestBody Post post);

    @GetMapping("/postReply/getEarliestPostReplyFromPost/{postID}")
    PostReply getEarliestPostReplyFromPost(@PathVariable("postID") int postID);

    @GetMapping("/postReply/getLatestPostReplyFromPost/{postID}")
    PostReply getLatestPostReplyFromPost(@PathVariable("postID") int postID);

    @GetMapping("/postReply/getAllReplyFromPost/{postID}")
    List<PostReply> getAllReplyFromPost(@PathVariable("postID") int postID);

    @PostMapping("/postReply/insertNewPostReply")
    int insertNewPostReply(@RequestBody PostReply postReply);


    @GetMapping("/userReply/selectUserReplyCount/{postReplyID}")
    int selectUserReplyCount(@PathVariable("postReplyID") int postReplyID);

    @GetMapping("/userReply/selectAllUserReply/{postReplyID}")
    public List<UserReply> selectAllUserReply(@PathVariable("postReplyID")int postReplyID);

    @PostMapping("/userReply/insertNewUserReply")
    public int insertNewUserReply(@RequestBody UserReply userReply);
}
