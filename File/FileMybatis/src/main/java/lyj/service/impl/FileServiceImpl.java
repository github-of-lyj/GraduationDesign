package lyj.service.impl;

import common.ConstantUtil;
import entities.MyFile;
import lyj.dao.FileMapper;
import lyj.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileDao;

    private static final String imagePrefix = "/imgs";
    private static final String zipPrefix = "/zips";

    @Override
    public ResponseEntity<Resource> getUserAvatar(String fileID) throws IOException {
        MyFile myFile = fileDao.getFilePath(fileID);
        String fileName = myFile.getFileName();
        String filePath = myFile.getFilePath();
        String imgUrl = ConstantUtil.FILE_PREFIX + imagePrefix + filePath;
        // 获取图片路径
        Path imgPath = Paths.get(imgUrl, fileName);

        // 读取图片资源
        Resource resource = new UrlResource(imgPath.toUri());

        // 判断图片是否存在并且可读
        if (resource.exists() && resource.isReadable()) {
            // 设置响应头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // 设置图片类型

            // 返回图片内容
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } else {
            // 图片不存在，返回404
            return ResponseEntity.notFound().build();
        }
    }
}
