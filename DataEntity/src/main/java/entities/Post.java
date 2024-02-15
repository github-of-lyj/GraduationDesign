package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postID;
    private String userName;
    private String blockName;
    private int replyNumber;
    private String postTitle;
    private String postDate;
}
