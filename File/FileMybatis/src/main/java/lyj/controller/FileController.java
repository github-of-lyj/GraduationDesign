package lyj.controller;

import lyj.dao.FileMapper;
import lyj.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/getUserAvatar/{fileID}")
    public ResponseEntity<Resource> getUserAvatar(@PathVariable("fileID") String fileID) throws IOException{
        return fileService.getUserAvatar(fileID);
    }


}
