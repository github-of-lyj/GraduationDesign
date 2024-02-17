package lyj.dao;

import entities.PostReplySearch;
import entities.PostSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostReplySearchMapper {
    List<PostReplySearch> selectVaguePostReply(@Param("searchField")String searchField);
}
