package lyj.service.impl;

import entities.PostReplySearch;
import lyj.dao.PostReplySearchMapper;
import lyj.service.PostReplySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReplySearchServiceImpl implements PostReplySearchService {
    @Autowired
    PostReplySearchMapper postReplySearchDAO;

    @Override
    public List<PostReplySearch> selectVaguePostReply(String searchField) {
        return postReplySearchDAO.selectVaguePostReply(searchField);
    }

    @Override
    public List<PostReplySearch> selectPostReply(int userID) {
        return postReplySearchDAO.selectPostReply(userID);
    }
}
