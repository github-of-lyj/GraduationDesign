package lyj.dao;

import entities.PostReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostReplyMapper {
    PostReply getEarliestPostReplyFromPost(@Param("postID")int postID);

    PostReply getLatestPostReplyFromPost(@Param("postID")int postID);

    List<PostReply> getAllReplyFromPost(@Param("postID")int postID);
}
