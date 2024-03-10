package lyj.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import common.BaseResponse;
import common.BusinessException;
import common.ErrorCode;
import entities.Post;
import lyj.MyTextCheck;
import lyj.dao.AuthorityMapper;
import lyj.dao.PostMapper;
import lyj.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postDAO;

    @Autowired
    AuthorityMapper authorityDAO;

    @Override
    @DS("slave")
    public List<Post> selectPostsByBlockID(int blockID) {
        return postDAO.selectPostsByBlockID(blockID);
    }

    @Override
    @DS("slave")
    public Post selectPostByPostID(int postID) {
        return postDAO.selectPostByPostID(postID);
    }

    @Override
    @DS("slave")
    public int selectPostNumberByUserName(String userName) {
        return postDAO.selectPostNumberByUserName(userName);
    }

    @Override
    public int insertNewPost(Post post) {
        String authority = authorityDAO.selectUserAuthorityByUserID(post.getUserID());
        if (authority.indexOf('2') == -1)
            throw new BusinessException(ErrorCode.NO_AUTH,"你小子被禁言了");
        //文本检测
        BaseResponse baseResponse = MyTextCheck.checkText(post.getPostTitle());
        if (baseResponse.getCode() != 0){
            if (baseResponse.getCode() == 601)
                throw new BusinessException(ErrorCode.PARAMS_ERROR,baseResponse.getDescription());
            if (baseResponse.getCode() == 603)
                throw new BusinessException(ErrorCode.TEXT_VIOLATION,"帖子标题违规，违规类型:" + baseResponse.getDescription());
        }
        //检测通过后
        String postDate = String.valueOf(DateUtil.date());
        post.setReplyNumber(-1);
        post.setPostDate(postDate);
        postDAO.insertNewPost(post);
        return post.getPostID();
    }
}
