package lyj.service.impl;

import entities.PostReply;
import lyj.dao.PostReplyMapper;
import lyj.service.PostReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReplyServiceImpl implements PostReplyService {
    @Autowired
    PostReplyMapper PostReplyDAO;

    @Override
    public PostReply getEarliestPostReplyFromPost(int postID) {
        return PostReplyDAO.getEarliestPostReplyFromPost(postID);
    }

    @Override
    public PostReply getLatestPostReplyFromPost(int postID) {
        return PostReplyDAO.getLatestPostReplyFromPost(postID);
    }

    @Override
    public List<PostReply> getAllReplyFromPost(int postID) {
        return PostReplyDAO.getAllReplyFromPost(postID);
    }
}
