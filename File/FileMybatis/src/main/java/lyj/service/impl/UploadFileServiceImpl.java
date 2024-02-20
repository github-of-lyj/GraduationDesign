package lyj.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import common.ConstantUtil;
import entities.UploadFile;
import lyj.dao.UploadFileMapper;
import lyj.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    UploadFileMapper uploadFileDAO;

    private static final String zipPrefix = "/zips";


    @Override
    public List<UploadFile> selectAllUploadFile() {
        return uploadFileDAO.selectAllUploadFile();
    }

    @Override
    public int uploadFile(MultipartFile file, int userID) {
        if (file.isEmpty()){
            return -1;
        }
        try {
            //根据当前时间确定该文件的存储路径
            String now = DateUtil.now();
            DateTime nowTime = DateUtil.parse(now);
            String year = '/' + String.valueOf(DateUtil.year(nowTime));
            String month = '/' + String.valueOf(DateUtil.month(nowTime));
            String day = '/' + String.valueOf(DateUtil.dayOfMonth(nowTime));
            String hour = '/' + String.valueOf(DateUtil.hour(nowTime, true));
            String fileSuffix = String.valueOf(DateUtil.currentSeconds());
            //获取存储关键路径
            String fileUrl = year + month + day + hour;
            //拼接后得到最终的存储路径
            File uploadDirFile = new File(ConstantUtil.FILE_PREFIX + zipPrefix + fileUrl);
            //若相应的目录不存在，则创建
            if (!uploadDirFile.exists())
                uploadDirFile.mkdirs();
            //创建相应的图片
            String fileName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
            File destFile = new File(ConstantUtil.FILE_PREFIX + zipPrefix + fileUrl + "/" + fileName + "-" + fileSuffix + ".zip");
            file.transferTo(destFile);
            UploadFile uploadFile = new UploadFile();
            uploadFile.setUploadfileName(fileName + "-" + fileSuffix + ".zip");
            uploadFile.setUploadfilePath(fileUrl);
            uploadFile.setUserID(userID);
            uploadFile.setDownloadCounts(0);
            uploadFile.setUploadfileSize(String.valueOf(file.getSize() / (1024)));
            uploadFile.setUploadDate(String.valueOf(DateUtil.date()));
            uploadFileDAO.uploadFile(uploadFile);
            return uploadFile.getUploadfileID();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ResponseEntity<Resource> getFile(UploadFile uploadFile) throws IOException {
        String uploadFilePath = uploadFile.getUploadfilePath();
        String uploadFileName = uploadFile.getUploadfileName();

        // 对文件名进行URL编码
        String encodedFileName = URLEncoder.encode(uploadFileName, StandardCharsets.UTF_8);

        File file = new File(ConstantUtil.FILE_PREFIX + zipPrefix + uploadFilePath + '/' + uploadFileName);
        FileSystemResource resource = new FileSystemResource(file);

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        uploadFileDAO.addDownloadCount(uploadFile.getUploadfileID());
        HttpHeaders headers = new HttpHeaders();

        // 使用URL编码后的文件名
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFileName + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
