package lyj.dao;

import entities.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostManageMapper {
    List<Post> selectPost(@Param("searchField")String searchField);
}
