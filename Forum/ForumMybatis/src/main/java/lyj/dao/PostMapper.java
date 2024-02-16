package lyj.dao;

import entities.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> selectPostsByBlockID(@Param("blockID")int blockID);

    Post selectPostByPostID(@Param("postID")int postID);

    int selectPostNumberByUserName(@Param("userName")String userName);

    int insertNewPost(@Param("post")Post post);
}
