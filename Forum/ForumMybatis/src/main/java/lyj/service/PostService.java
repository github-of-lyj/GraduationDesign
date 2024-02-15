package lyj.service;

import entities.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostService {
    List<Post> selectPostsByBlockID(int blockID);


}
