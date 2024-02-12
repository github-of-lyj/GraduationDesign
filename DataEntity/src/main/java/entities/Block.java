package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {
    private int BlockID;
    private String zoneName;
    private String BlockName;
    private String BlockIntroduce;
    private int postNumber;
    private int followers;
}
