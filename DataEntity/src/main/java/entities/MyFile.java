package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFile {
    private String fileID;
    private String userID;
    private String fileName;
    private String filePath;
}
