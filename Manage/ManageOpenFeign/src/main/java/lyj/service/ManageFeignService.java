package lyj.service;

import entities.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "manage-mybatis")
public interface ManageFeignService {

    @RequestMapping("/UserManage/selectUser/{searchField}")
    List<User> selectUser(@PathVariable("searchField") String searchField);

    @PostMapping("/UserManage/modifyUserAuthority/{userID}/{authority}")
    void modifyUserAuthority(@PathVariable("userID") int userID,@PathVariable("authority") String authority);

    @GetMapping("/PostManage/selectPost/{searchField}")
    List<Post> selectPost(@PathVariable("searchField") String searchField);

    @PostMapping("/PostManage/deletePost/{postID}")
    void deletePost(@PathVariable("postID") int postID);

    @GetMapping("/PostReplyManage/selectPostReply/{searchField}")
    List<PostReply> selectPostReply(@PathVariable("searchField") String searchField);

    @PostMapping("/PostReplyManage/deletePostReply/{postReplyID}")
    void deletePostReply(@PathVariable("postReplyID") int postReplyID);

    @GetMapping("/UserReplyManage/selectUserReply/{searchField}")
    List<UserReply> selectUserReply(@PathVariable("searchField") String searchField);

    @PostMapping("/UserReplyManage/deleteUserReply/{userReplyID}")
    void deleteUserReply(@PathVariable("userReplyID")int userReplyID);

    @PostMapping("/Report/insertNewReport")
    int insertNewReport(@RequestBody Report reportData);

    @GetMapping("/Report/selectReport/{searchField}")
    List<Report> selectReport(@PathVariable("searchField") String searchField);
}
