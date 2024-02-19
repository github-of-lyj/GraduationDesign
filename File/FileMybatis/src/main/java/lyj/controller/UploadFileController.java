package lyj.controller;

import entities.UploadFile;
import lyj.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/uploadfile")
public class UploadFileController {

    @Autowired
    UploadFileService uploadFileService;

    @GetMapping("/selectAllUploadFile")
    public List<UploadFile> selectAllUploadFile(){
        return uploadFileService.selectAllUploadFile();
    }

    @PostMapping("/upload")
    public int uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userID")int userID){
        return uploadFileService.uploadFile(file,userID);
    }
}
