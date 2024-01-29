package lyj.service.impl;

import entities.College;
import lyj.dao.CollegeMapper;
import lyj.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper CollegeDao;

    @Override
    public College getRandomCollege() {
        return CollegeDao.getRandomCollege();
    }

    @Override
    public String getCollegeCodeByCollegeName(String collegeName) {
        return CollegeDao.getCollegeCodeByCollegeName(collegeName);
    }
}
