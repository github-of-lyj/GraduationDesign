package lyj.service.impl;

import lyj.dao.CountryMapper;
import lyj.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryMapper CountryDao;
}
