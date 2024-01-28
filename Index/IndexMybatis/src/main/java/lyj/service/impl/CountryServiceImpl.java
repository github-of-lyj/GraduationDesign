package lyj.service.impl;

import entities.Country;
import entities.University;
import lyj.dao.CountryMapper;
import lyj.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryMapper CountryDao;


    @Override
    public List<Country> getCountriesByType(String type, int limit) {
        return CountryDao.getCountriesByType(type,limit);
    }
}
