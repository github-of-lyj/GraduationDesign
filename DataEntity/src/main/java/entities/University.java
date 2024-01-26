package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class University {
    private String collegeCode;
    private String policyName;
    private String policydate;
    private String policyurl;
}
