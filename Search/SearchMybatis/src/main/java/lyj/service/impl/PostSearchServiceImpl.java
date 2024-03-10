package lyj.service.impl;

import common.SearchJudgeUtil;
import entities.PostReplySearch;
import entities.PostSearch;
import lyj.dao.PostSearchMapper;
import lyj.service.PostSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSearchServiceImpl implements PostSearchService {
    @Autowired
    PostSearchMapper postSearchDAO;

    @Override
    public List<PostSearch> selectVaguePost(String postTitle) {
        List<PostSearch> postReplySearches = postSearchDAO.selectVaguePost("");
        List<PostSearch> result = new ArrayList<>();
        for (PostSearch postSearch : postReplySearches) {
            if (SearchJudgeUtil.isContain(postTitle,postSearch.getPostTitle()))
                result.add(postSearch);
        }
        return result;
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
