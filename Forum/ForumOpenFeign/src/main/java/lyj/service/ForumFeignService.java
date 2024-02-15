package lyj.service;

import entities.Block;
import entities.Post;
import entities.PostReply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public int selectPostNumberByUserName(@PathVariable("userName") String userName);

    @GetMapping("/postReply/getEarliestPostReplyFromPost/{postID}")
    PostReply getEarliestPostReplyFromPost(@PathVariable("postID") int postID);

    @GetMapping("/postReply/getLatestPostReplyFromPost/{postID}")
    PostReply getLatestPostReplyFromPost(@PathVariable("postID") int postID);

    @GetMapping("/postReply/getAllReplyFromPost/{postID}")
    List<PostReply> getAllReplyFromPost(@PathVariable("postID") int postID);
}
