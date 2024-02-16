package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postID;
    //用户ID以及用户姓名
    private int userID;
    private String userName;
    //板块ID以及板块名称
    private int blockID;
    private String blockName;
    //回复数
    private int replyNumber;
    //帖子标题
    private String postTitle;
    //发表时间
    private String postDate;
}
