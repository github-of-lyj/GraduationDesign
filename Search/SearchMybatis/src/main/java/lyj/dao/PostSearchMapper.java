package lyj.dao;

import entities.Post;
import entities.PostReply;
import entities.PostSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostSearchMapper {
    List<PostSearch> selectVaguePost(@Param("searchField")String searchField);

    List<PostSearch> selectHotPost();

    List<PostSearch> selectUserPost(@Param("userID")int userID);
}
