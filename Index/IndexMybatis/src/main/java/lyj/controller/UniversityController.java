package lyj.controller;

import entities.University;
import lyj.service.UniversityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityService universityDao;

    @RequestMapping("/{collegeCode}/{limit}")
    public List<University> getUniversitiesByID(@PathVariable("collegeCode") String collegeCode, @PathVariable("limit") int limit){
        return universityDao.getUniversitiesByID(collegeCode,limit);
    }
}
