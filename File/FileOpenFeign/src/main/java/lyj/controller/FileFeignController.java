package lyj.controller;

import lyj.service.FileFeignService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user/file")
public class FileFeignController {

    @jakarta.annotation.Resource
    FileFeignService fileFeignService;

    @GetMapping("/getUserAvatar/{fileID}")
    public ResponseEntity<Resource> getUserAvatar(@PathVariable("fileID") String fileID) throws IOException{
        return fileFeignService.getUserAvatar(fileID);
    }

    @PostMapping(value = "/uploadUserAvatar")
    public int uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("userID")int userID){
        return fileFeignService.uploadUserAvatar(file,userID);
    }


}
