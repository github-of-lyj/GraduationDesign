package lyj.dao;

import entities.University;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UniversityMapper {
    List<University> getUniversitiesByID(@Param("collegeCode") String collegeCode,@Param("limit") int limit);
}
