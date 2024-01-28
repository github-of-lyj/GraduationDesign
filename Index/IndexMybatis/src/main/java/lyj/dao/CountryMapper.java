package lyj.dao;

import entities.Country;
import entities.University;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CountryMapper {
    List<Country> getCountriesByType(@Param("type") String type, @Param("limit") int limit);
}
