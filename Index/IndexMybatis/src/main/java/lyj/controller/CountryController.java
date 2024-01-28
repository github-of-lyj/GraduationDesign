package lyj.controller;

import entities.Country;
import entities.University;
import lyj.service.CountryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryDao;

    @RequestMapping("/{type}/{limit}")
    List<Country> getCountriesByType(@PathVariable("type") String type, @PathVariable("limit") int limit){
        return countryDao.getCountriesByType(type, limit);
    }
}
