package lyj.service;

import entities.PostReplySearch;
import entities.PostSearch;
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

    @GetMapping("/PostReplySearch/getPostReply/{searchField}")
    List<PostReplySearch> selectVaguePostReply(@PathVariable("searchField") String searchField);

}
