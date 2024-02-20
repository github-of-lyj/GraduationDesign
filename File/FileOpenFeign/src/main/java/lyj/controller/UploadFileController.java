package lyj.controller;

import entities.UploadFile;
import jakarta.annotation.Resource;
import lyj.service.FileFeignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user/uploadfile")
public class UploadFileController {
    @Resource
    FileFeignService fileService;

    @PostMapping("/upload")
    public int uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userID")int userID){
        return fileService.uploadFile(file,userID);
    }

    @GetMapping("/selectAllUploadFile")
    public List<UploadFile> selectAllUploadFile(){
        return fileService.selectAllUploadFile();
    }

    @PostMapping("/getFile")
    ResponseEntity<org.springframework.core.io.Resource> getFile(@RequestBody UploadFile uploadFile) throws IOException{
        System.out.println(uploadFile);
        return fileService.getFile(uploadFile);
    }
}
