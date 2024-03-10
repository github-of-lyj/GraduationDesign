package lyj.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@DS("master")
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileDao;

    private static final String imagePrefix = "/imgs";


    @Override
    @DS("slave")
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

    @Override
    public int uploadUserAvatar(MultipartFile file,int userID) {
        if (file.isEmpty()){
            return -1;
        }
        try {
            //根据当前时间确定该图片的存储路径
            String now = DateUtil.now();
            DateTime nowTime = DateUtil.parse(now);
            String year = '/' + String.valueOf(DateUtil.year(nowTime));
            String month = '/' + String.valueOf(DateUtil.month(nowTime));
            String day = '/' + String.valueOf(DateUtil.dayOfMonth(nowTime));
            String hour = '/' + String.valueOf(DateUtil.hour(nowTime, true));
            String fileName = String.valueOf(DateUtil.currentSeconds()) + ".jpg";
            //获取存储关键路径
            String imgUrl = year + month + day + hour;
            //拼接后得到最终的存储路径
            File uploadDirFile = new File(ConstantUtil.FILE_PREFIX + imagePrefix + imgUrl);
            //若相应的目录不存在，则创建
            if (!uploadDirFile.exists())
                uploadDirFile.mkdirs();
            //创建相应的图片
            File destFile = new File(ConstantUtil.FILE_PREFIX + imagePrefix + imgUrl + "/" + fileName);
            file.transferTo(destFile);
            MyFile myFile = new MyFile();
            myFile.setFileName(fileName);
            myFile.setFilePath(imgUrl);
            myFile.setUserID(userID);
            fileDao.uploadUserAvatar(myFile);
            return myFile.getFileID();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
