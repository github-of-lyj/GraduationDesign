package lyj.service.impl;

import entities.PostSearch;
import lyj.dao.PostSearchMapper;
import lyj.service.PostSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSearchServiceImpl implements PostSearchService {
    @Autowired
    PostSearchMapper postSearchDAO;

    @Override
    public List<PostSearch> selectVaguePost(String postTitle) {
        return postSearchDAO.selectVaguePost(postTitle);
    }

    @Override
    public List<PostSearch> selectHotPost() {
        return postSearchDAO.selectHotPost();
    }

    @Override
    public List<PostSearch> selectUserPost(int userID) {
        return postSearchDAO.selectUserPost(userID);
    }
}
