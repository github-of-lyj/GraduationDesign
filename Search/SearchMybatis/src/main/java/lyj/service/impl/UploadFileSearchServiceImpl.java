package lyj.service.impl;

import common.SearchJudgeUtil;
import entities.PostSearch;
import entities.UploadFile;
import lyj.dao.UploadFileSearchMapper;
import lyj.service.UploadFileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UploadFileSearchServiceImpl implements UploadFileSearchService {
    @Autowired
    UploadFileSearchMapper uploadFileSearchDAO;

    @Override
    public List<UploadFile> selectVagueUploadFile(String searchField) {
        List<UploadFile> uploadFileList = uploadFileSearchDAO.selectVagueUploadFile("");
        List<UploadFile> result = new ArrayList<>();
        for (UploadFile uploadFile : uploadFileList) {
            if (SearchJudgeUtil.isContain(searchField,uploadFile.getUploadfileName()))
                result.add(uploadFile);
        }
        return result;
    }
}
