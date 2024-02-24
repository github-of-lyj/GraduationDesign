package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReply {
    //用户回复ID
    private int userReplyID;
    //回复用户ID以及姓名
    private int userID;
    private String userName;
    //帖子ID以及帖子标题
    private int postID;
    private String postTitle;
    //回复的回复贴ID
    private int postReplyID;
    private String postReplyContent;
    //回复内容以及回复时间
    private String userReplyContent;
    private String userReplyTime;
}
