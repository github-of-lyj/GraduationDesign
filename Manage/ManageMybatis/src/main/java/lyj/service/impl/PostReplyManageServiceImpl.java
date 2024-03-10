package lyj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import entities.PostReply;
import lyj.dao.PostReplyManageMapper;
import lyj.service.PostReplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class PostReplyManageServiceImpl implements PostReplyManageService {
    @Autowired
    PostReplyManageMapper postReplyManageDAO;

    @Override
    @DS("slave")
    public List<PostReply> selectPostReply(String searchField) {
        return postReplyManageDAO.selectPostReply(searchField);
    }

    @Override
    public void deletePostReply(int postReplyID) {
        postReplyManageDAO.deletePostReply(postReplyID);
    }
}
