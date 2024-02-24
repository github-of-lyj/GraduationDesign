package lyj.service.impl;

import entities.PostReply;
import lyj.dao.PostReplyManageMapper;
import lyj.service.PostReplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReplyManageServiceImpl implements PostReplyManageService {
    @Autowired
    PostReplyManageMapper postReplyManageDAO;

    @Override
    public List<PostReply> selectPostReply(String searchField) {
        return postReplyManageDAO.selectPostReply(searchField);
    }
}
