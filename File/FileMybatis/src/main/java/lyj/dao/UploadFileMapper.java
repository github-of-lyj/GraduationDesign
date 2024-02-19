package lyj.dao;

import entities.MyFile;
import entities.UploadFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UploadFileMapper {
    List<UploadFile> selectAllUploadFile();

    int uploadFile(@Param("uploadfile") UploadFile uploadfile);
}
