package lyj.dao;

import entities.MyFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileMapper {
    MyFile getFilePath(@Param("fileID") String fileID);

}
