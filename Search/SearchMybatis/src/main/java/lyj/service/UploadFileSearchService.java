package lyj.service;

import entities.UploadFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UploadFileSearchService {
    List<UploadFile> selectVagueUploadFile(String searchField);
}
