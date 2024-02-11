package lyj.controller;

import lyj.service.FileFeignService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
