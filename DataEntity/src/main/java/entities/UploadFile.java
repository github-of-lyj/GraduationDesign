package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile {
    private int uploadfileID;
    private int userID;
    private String userName;
    private String uploadfileName;
    private String uploadfilePath;
    private String uploadfileSize;
    private int downloadCounts;
    private String uploadDate;
}
