package lyj.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import common.BaseResponse;
import common.BusinessException;
import common.ErrorCode;
import entities.PostReply;
import lyj.MyTextCheck;
import lyj.dao.AuthorityMapper;
import lyj.dao.PostReplyMapper;
import lyj.service.PostReplyService;
import lyj.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class PostReplyServiceImpl implements PostReplyService {
    @Autowired
    PostReplyMapper PostReplyDAO;

    @Autowired
    AuthorityMapper authorityDAO;

    @Autowired
    RedisUtil redisUtil;

    @Override
    @DS("slave")
    public PostReply getEarliestPostReplyFromPost(int postID) {
        return PostReplyDAO.getEarliestPostReplyFromPost(postID);
    }

    @Override
    @DS("slave")
    public PostReply getLatestPostReplyFromPost(int postID) {
        return PostReplyDAO.getLatestPostReplyFromPost(postID);
    }

    @Override
    @DS("slave")
    public List<PostReply> getAllReplyFromPost(int postID) {
        return PostReplyDAO.getAllReplyFromPost(postID);
    }

    @Override
    public int insertNewPostReply(PostReply postReply) {
        String authority = authorityDAO.selectUserAuthorityByUserID(postReply.getUserID());
        if (authority.indexOf('2') == -1)
            throw new BusinessException(ErrorCode.NO_AUTH,"你小子被禁言了");
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
        redisUtil.setPostReply(postReply);
        return postReply.getPostReplyID();
    }

    @Override
    public List getNewPostReplyList(int userID) {
        return redisUtil.getNewLatestPostReplyList(userID);
    }

    @Override
    public void delNewPostHis(int userID, int postID) {
        redisUtil.delPostReply(userID,postID);
    }
}
