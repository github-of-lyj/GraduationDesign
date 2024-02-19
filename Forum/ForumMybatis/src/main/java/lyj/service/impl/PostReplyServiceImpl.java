package lyj.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import common.BaseResponse;
import common.BusinessException;
import common.ErrorCode;
import entities.PostReply;
import lyj.MyTextCheck;
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

    @Override
    public int insertNewPostReply(PostReply postReply) {
        //文本检测
        BaseResponse baseResponse = MyTextCheck.checkText(postReply.getPostReplyContent());
        if (baseResponse.getCode() != 0){
            if (baseResponse.getCode() == 601)
                throw new BusinessException(ErrorCode.PARAMS_ERROR,baseResponse.getDescription());
            if (baseResponse.getCode() == 603)
                throw new BusinessException(ErrorCode.TEXT_VIOLATION,"发言内容违规，违规类型:" + baseResponse.getDescription());
        }
        //检测通过后
        String postReplyTime = String.valueOf(DateUtil.date());
        postReply.setPostReplyTime(postReplyTime);
        PostReplyDAO.insertNewPostReply(postReply);
        PostReplyDAO.addPostReplyNumber(postReply.getPostID());
        return postReply.getPostReplyID();
    }
}
