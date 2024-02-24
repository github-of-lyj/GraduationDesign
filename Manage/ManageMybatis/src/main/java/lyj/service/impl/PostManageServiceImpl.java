package lyj.service.impl;

import entities.Post;
import lyj.dao.PostManageMapper;
import lyj.service.PostManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManageServiceImpl implements PostManageService {
    @Autowired
    PostManageMapper postManageDAO;

    @Override
    public List<Post> selectPost(String searchField) {
        return postManageDAO.selectPost(searchField);
    }
}
