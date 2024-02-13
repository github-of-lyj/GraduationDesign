package lyj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@FeignClient(value = "file-mybatis")
public interface FileFeignService {
    @GetMapping("/file/getUserAvatar/{fileID}")
    public ResponseEntity<Resource> getUserAvatar(@PathVariable("fileID") String fileID) throws IOException;

    @PostMapping(value = "/file/uploadUserAvatar",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    int uploadUserAvatar(@RequestPart("file") MultipartFile file,@RequestParam("userID")int userID);
}
