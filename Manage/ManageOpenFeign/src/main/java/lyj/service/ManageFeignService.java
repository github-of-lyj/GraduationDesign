package lyj.service;

import entities.Post;
import entities.PostReply;
import entities.User;
import entities.UserReply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
