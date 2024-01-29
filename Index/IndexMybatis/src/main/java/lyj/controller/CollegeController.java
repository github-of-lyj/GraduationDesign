package lyj.controller;

import entities.College;
import lyj.service.CollegeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeDao;

    @RequestMapping("/random")
    public College getRandomCollege(){
        return collegeDao.getRandomCollege();
    }

    @RequestMapping("/{collegeName}")
    String getCollegeCodeByCollegeName(@PathVariable("collegeName")String collegeName){
        return collegeDao.getCollegeCodeByCollegeName(collegeName);
    }
}
