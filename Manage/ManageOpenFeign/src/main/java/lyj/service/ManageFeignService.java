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

    @GetMapping("/PostManage/selectPost/{searchField}")
    List<Post> selectPost(@PathVariable("searchField") String searchField);

    @GetMapping("/PostReplyManage/selectPostReply/{searchField}")
    List<PostReply> selectPostReply(@PathVariable("searchField") String searchField);

    @GetMapping("/UserReplyManage/selectUserReply/{searchField}")
    List<UserReply> selectUserReply(@PathVariable("searchField") String searchField);

    @PostMapping("/Report/insertNewReport")
    int insertNewReport(@RequestBody Report reportData);

    @GetMapping("/Report/selectReport/{searchField}")
    List<Report> selectReport(@PathVariable("searchField") String searchField);
}
