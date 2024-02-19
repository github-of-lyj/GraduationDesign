package lyj.controller;


import lyj.service.FileService;
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


@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/getUserAvatar/{fileID}")
    public ResponseEntity<Resource> getUserAvatar(@PathVariable("fileID") String fileID) throws IOException{
        return fileService.getUserAvatar(fileID);
    }

    @PostMapping("/uploadUserAvatar")
    public int uploadUserAvatar(@RequestParam("file") MultipartFile file,@RequestParam("userID")int userID){
        return fileService.uploadUserAvatar(file,userID);
    }

    @GetMapping("/files/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws IOException {
        File file = new File("D://FILES/imgs/initial/" + fileName); // 修改为你文件的实际路径
        FileSystemResource resource = new FileSystemResource(file);

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


}
