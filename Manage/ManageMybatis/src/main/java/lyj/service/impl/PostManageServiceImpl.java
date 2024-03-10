package lyj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import entities.Post;
import lyj.dao.PostManageMapper;
import lyj.service.PostManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class PostManageServiceImpl implements PostManageService {
    @Autowired
    PostManageMapper postManageDAO;

    @Override
    @DS("slave")
    public List<Post> selectPost(String searchField) {
        return postManageDAO.selectPost(searchField);
    }

    @Override
    public void deletePost(int postID) {
        postManageDAO.deletePost(postID);
    }
}
