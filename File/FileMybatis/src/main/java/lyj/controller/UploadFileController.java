package lyj.controller;

import common.ConstantUtil;
import entities.UploadFile;
import lyj.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @PostMapping("/getFile")
    public ResponseEntity<Resource> getFile(@RequestBody UploadFile uploadFile) throws IOException{
        System.out.println(uploadFile);
        return uploadFileService.getFile(uploadFile);
    }




}
