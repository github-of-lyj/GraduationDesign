package lyj.service;

import entities.PostSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostSearchService {
    List<PostSearch> selectVaguePost(@Param("postTitle")String postTitle);
}
