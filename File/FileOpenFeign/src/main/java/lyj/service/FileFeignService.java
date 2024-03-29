package lyj.service;

import entities.UploadFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
@FeignClient(value = "file-mybatis")
public interface FileFeignService {
    @GetMapping("/file/getUserAvatar/{fileID}")
    ResponseEntity<Resource> getUserAvatar(@PathVariable("fileID") String fileID) throws IOException;

    @PostMapping(value = "/file/uploadUserAvatar",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    int uploadUserAvatar(@RequestPart("file") MultipartFile file,@RequestParam("userID")int userID);

    @GetMapping("/uploadfile/selectAllUploadFile")
    List<UploadFile> selectAllUploadFile();

    @PostMapping(value = "/uploadfile/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    int uploadFile(@RequestPart("file") MultipartFile file, @RequestParam("userID")int userID);

    @PostMapping("/uploadfile/getFile")
    ResponseEntity<Resource> getFile(@RequestBody UploadFile uploadFile) throws IOException;

}
