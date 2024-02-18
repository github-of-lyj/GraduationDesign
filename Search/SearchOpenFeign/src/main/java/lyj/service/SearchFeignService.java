package lyj.service;

import entities.PostReplySearch;
import entities.PostSearch;
import entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient("search-mybatis")
public interface SearchFeignService {
    @GetMapping("/PostSearch/getPost/{searchField}")
    List<PostSearch> selectVaguePost(@PathVariable("searchField") String searchField);

    @GetMapping("/PostSearch/selectUserPost/{userID}")
    List<PostSearch> selectUserPost(@PathVariable("userID")int userID);

    @GetMapping("/PostReplySearch/getPostReply/{searchField}")
    List<PostReplySearch> selectVaguePostReply(@PathVariable("searchField") String searchField);

    @GetMapping("/PostReplySearch/selectPostReply/{userID}")
    List<PostReplySearch> selectPostReply(@PathVariable("userID")int userID);

    @GetMapping("/UserSearch/getUser/{searchField}")
    List<User> selectVagueUser(@PathVariable("searchField") String searchField);

    @GetMapping("/UserSearch/selectUser/{userID}")
    User selectUser(@PathVariable("userID") int userID);

}
