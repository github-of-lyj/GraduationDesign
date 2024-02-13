package lyj.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    ResponseEntity<Resource> getUserAvatar(String fileID) throws IOException;

    int uploadUserAvatar(MultipartFile file,int userID);
}
