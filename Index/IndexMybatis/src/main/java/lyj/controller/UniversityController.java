package lyj.controller;

import entities.University;
import lyj.service.CollegeService;
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

    @Autowired
    private CollegeService collegeDao;

    @RequestMapping("/{collegeCode}/{limit}")
    public List<University> getUniversitiesByID(@PathVariable("collegeCode") String collegeCode, @PathVariable("limit") int limit){
        return universityDao.getUniversitiesByID(collegeCode,limit);
    }

    @RequestMapping("/name/{collegeName}/{limit}")
    public List<University> getUniversitiesByCollegeName(@PathVariable("collegeName") String collegeName,@PathVariable("limit") int limit){
        String collegeCode = collegeDao.getCollegeCodeByCollegeName(collegeName);
        return universityDao.getUniversitiesByID(collegeCode,limit);
    }
}
