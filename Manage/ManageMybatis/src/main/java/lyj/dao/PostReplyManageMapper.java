package lyj.dao;

import entities.PostReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostReplyManageMapper {
    List<PostReply> selectPostReply(@Param("searchField")String searchField);
}
