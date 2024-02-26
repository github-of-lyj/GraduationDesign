package lyj.service;

import entities.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostManageService {
    List<Post> selectPost(String searchField);

    void deletePost(int postID);
}
