package lyj.service;


import entities.Country;
import entities.University;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryService {
    List<Country> getCountriesByType(String type, int limit);
}
