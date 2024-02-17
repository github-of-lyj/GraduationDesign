package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReplySearch {
    //板块ID以及板块名称
    private int blockID;
    private String blockName;
    //帖子ID以及帖子标题
    private int postID;
    private String postTitle;
    //用户ID以及用户姓名
    private int userID;
    private String userName;
    //回复内容以及回复时间
    private int postReplyID;
    private String postReplyContent;
    private String postReplyTime;
}
