package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReply {
    private int postReplyID;
    //用户ID以及用户姓名
    private int userID;
    private String userName;
    //帖子ID以及帖子标题
    private int postID;
    private String postTitle;
    //回复内容
    private String postReplyContent;
    //回复时间
    private String postReplyTime;
}
