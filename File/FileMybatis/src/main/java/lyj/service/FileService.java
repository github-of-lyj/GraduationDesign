package lyj.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FileService {
    ResponseEntity<Resource> getUserAvatar(String fileID) throws IOException;
}
