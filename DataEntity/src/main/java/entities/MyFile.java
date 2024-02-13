package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFile {
    private int fileID;
    private int userID;
    private String fileName;
    private String filePath;
}
