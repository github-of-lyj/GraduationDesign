package lyj.controller;

import entities.University;
import feign.Param;
import jakarta.annotation.Resource;
import lyj.service.IndexFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/university")
public class UniversityFeignController {
    @Resource
    private IndexFeignService indexService;

    @RequestMapping("/{collegeCode}/{limit}")
    public List<University> getUniversitiesByID(@PathVariable("collegeCode") String collegeCode, @PathVariable("limit") int limit){
        return indexService.getUniversitiesByID(collegeCode,limit);
    }

    @RequestMapping("/name/{collegeName}/{limit}")
    public List<University> getUniversitiesByCollegeName(@PathVariable("collegeName") String collegeName,@PathVariable("limit") int limit){
        String collegeCode = indexService.getCollegeCodeByCollegeName(collegeName);
        return indexService.getUniversitiesByID(collegeCode,limit);
    }
}
