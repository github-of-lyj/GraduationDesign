package lyj.service;

import entities.College;
import entities.Country;
import entities.University;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "index-mybatis")
public interface IndexFeignService {
    @RequestMapping("/college/random")
    College getRandomCollege();

    @RequestMapping("/college/{collegeName}")
    String getCollegeCodeByCollegeName(@PathVariable("collegeName")String collegeName);

    @RequestMapping("/country/{type}/{limit}")
    List<Country> getCountriesByType(@PathVariable("type") String type, @PathVariable("limit") int limit);

    @RequestMapping("/university/{collegeCode}/{limit}")
    List<University> getUniversitiesByID(@PathVariable("collegeCode") String collegeCode, @PathVariable("limit") int limit);

    @RequestMapping("/university/name/{collegeName}/{limit}")
    List<University> getUniversitiesByCollegeName(@PathVariable("collegeName") String collegeName,@PathVariable("limit") int limit);





}
