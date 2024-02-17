package lyj.service;

import entities.PostReplySearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostReplySearchService {
    List<PostReplySearch> selectVaguePostReply(@Param("searchField")String searchField);
}
