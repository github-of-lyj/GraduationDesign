package lyj.service;

import entities.PostReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostReplyManageService {
    List<PostReply> selectPostReply(String searchField);
}
