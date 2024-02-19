package lyj.service.impl;

import cn.hutool.core.date.DateUtil;
import common.BaseResponse;
import common.BusinessException;
import common.ErrorCode;
import entities.UserReply;
import lyj.MyTextCheck;
import lyj.dao.PostReplyMapper;
import lyj.dao.UserReplyMapper;
import lyj.service.UserReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReplyServiceImpl implements UserReplyService {
    @Autowired
    UserReplyMapper UserReplyDAO;

    @Autowired
    PostReplyMapper PostReplyDAO;

    @Override
    public int selectUserReplyCount(int postReplyID) {
        return UserReplyDAO.selectUserReplyCount(postReplyID);
    }

    @Override
    public List<UserReply> selectAllUserReply(int postReplyID) {
        return UserReplyDAO.selectAllUserReply(postReplyID);
    }

    @Override
    public int insertNewUserReply(UserReply userReply) {
        //文本检测
        BaseResponse baseResponse = MyTextCheck.checkText(userReply.getUserReplyContent());
        if (baseResponse.getCode() != 0){
            if (baseResponse.getCode() == 601)
                throw new BusinessException(ErrorCode.PARAMS_ERROR,baseResponse.getDescription());
            if (baseResponse.getCode() == 603)
                throw new BusinessException(ErrorCode.TEXT_VIOLATION,"发言内容违规，违规类型:" + baseResponse.getDescription());
        }
        //检测通过后
        String userReplyTime = String.valueOf(DateUtil.date());
        userReply.setUserReplyTime(userReplyTime);
        UserReplyDAO.insertNewUserReply(userReply);
        PostReplyDAO.addPostReplyNumber(userReply.getPostID());
        return userReply.getUserReplyID();
    }
}
