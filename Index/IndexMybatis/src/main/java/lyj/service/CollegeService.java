package lyj.service;

import entities.College;
import org.apache.ibatis.annotations.Param;

public interface CollegeService {
    College getRandomCollege();

    String getCollegeCodeByCollegeName(String collegeName);
}
