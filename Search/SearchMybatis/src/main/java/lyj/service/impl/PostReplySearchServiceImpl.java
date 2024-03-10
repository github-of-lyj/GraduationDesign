package lyj.service.impl;

import common.SearchJudgeUtil;
import entities.PostReplySearch;
import entities.PostSearch;
import lyj.dao.PostReplySearchMapper;
import lyj.service.PostReplySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostReplySearchServiceImpl implements PostReplySearchService {
    @Autowired
    PostReplySearchMapper postReplySearchDAO;

    @Override
    public List<PostReplySearch> selectVaguePostReply(String searchField) {
        List<PostReplySearch> postReplySearches = postReplySearchDAO.selectVaguePostReply("");
        List<PostReplySearch> result = new ArrayList<>();
        for (PostReplySearch postReplySearch : postReplySearches) {
            if (SearchJudgeUtil.isContain(searchField,postReplySearch.getPostReplyContent()))
                result.add(postReplySearch);
        }
        return result;
    }

    @Override
    public List<PostReplySearch> selectHotPostReply() {
        return postReplySearchDAO.selectHotPostReply();
    }

    @Override
    public List<PostReplySearch> selectPostReply(int userID) {
        return postReplySearchDAO.selectPostReply(userID);
    }
}
