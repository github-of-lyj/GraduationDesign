package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReply {
    private int postReplyID;
    private String userName;
    private String postTitle;
    private String postReplyContent;
    private String postReplyTime;
}
