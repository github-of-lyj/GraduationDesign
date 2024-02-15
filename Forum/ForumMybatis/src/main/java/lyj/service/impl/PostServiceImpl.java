package lyj.service.impl;

import entities.Post;
import lyj.dao.PostMapper;
import lyj.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postDAO;

    @Override
    public List<Post> selectPostsByBlockID(int blockID) {
        return postDAO.selectPostsByBlockID(blockID);
    }

    @Override
    public Post selectPostByPostID(int postID) {
        return postDAO.selectPostByPostID(postID);
    }

    @Override
    public int selectPostNumberByUserName(String userName) {
        return postDAO.selectPostNumberByUserName(userName);
    }
}
