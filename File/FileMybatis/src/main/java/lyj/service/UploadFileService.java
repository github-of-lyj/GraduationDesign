package lyj.service;

import entities.UploadFile;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UploadFileService {
    List<UploadFile> selectAllUploadFile();

    int uploadFile(MultipartFile file, int userID);

    ResponseEntity<Resource> getFile(UploadFile uploadFile) throws IOException;
}
