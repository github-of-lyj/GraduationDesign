package lyj.service.impl;

import entities.UploadFile;
import lyj.dao.UploadFileSearchMapper;
import lyj.service.UploadFileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadFileSearchServiceImpl implements UploadFileSearchService {
    @Autowired
    UploadFileSearchMapper uploadFileSearchDAO;

    @Override
    public List<UploadFile> selectVagueUploadFile(String searchField) {
        return uploadFileSearchDAO.selectVagueUploadFile(searchField);
    }
}
