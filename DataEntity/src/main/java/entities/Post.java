package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postID;
    private int userID;
    private int blockID;
    private int replyNumber;
    private String postTitle;
    private String postDate;
}
