package lyj.dao;

import entities.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollegeMapper {
    College getRandomCollege();

    String getCollegeCodeByCollegeName(@Param("collegeName")String collegeName);
}
