package lyj.service;

import entities.University;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UniversityService {
    List<University> getUniversitiesByID(@Param("collegeCode") String collegeCode, @Param("limit") int limit);
}
