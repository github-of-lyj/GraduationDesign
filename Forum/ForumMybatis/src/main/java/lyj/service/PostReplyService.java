package lyj.service;

import entities.PostReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostReplyService {
    PostReply getEarliestPostReplyFromPost(int postID);

    PostReply getLatestPostReplyFromPost(int postID);

    List<PostReply> getAllReplyFromPost(int postID);

    int insertNewPostReply(PostReply postReply);

    List getNewPostReplyList(int userID);

    void delNewPostHis(int userID,int postID);
}
