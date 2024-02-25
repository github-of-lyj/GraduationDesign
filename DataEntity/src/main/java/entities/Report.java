package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private int reportID;
    //举报内容的类别以及ID
    private String reportContentPosition;
    private int reportContentID;
    //举报内容
    private String reportContent;
    //被举报内容的发表用户（举报用户时可以为空）
    private String publishUser;
    //举报理由和举报描述
    private String reportReason;
    private String reportDescription;
    //举报用户
    private String reportUser;
}
