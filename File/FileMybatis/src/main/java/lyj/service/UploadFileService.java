package lyj.service;

import entities.UploadFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadFileService {
    List<UploadFile> selectAllUploadFile();

    int uploadFile(MultipartFile file, int userID);
}
