package lyj.service.impl;

import entities.University;
import lyj.dao.UniversityMapper;
import lyj.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityMapper UniversityDao;


    @Override
    public List<University> getUniversitiesByID(String collegeCode, int limit) {
        return UniversityDao.getUniversitiesByID(collegeCode,limit);
    }
}
