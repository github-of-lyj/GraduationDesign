package lyj.dao;

import entities.College;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeMapper {
    College getRandomCollege();
}
