package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReply {
    private int postReplyID;
    private int userID;
    private int postID;
    private String postReplyContent;
    private String postReplyTime;
}
