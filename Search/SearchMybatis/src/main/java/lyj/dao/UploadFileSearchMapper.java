package lyj.dao;

import entities.UploadFile;
import entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UploadFileSearchMapper {
    List<UploadFile> selectVagueUploadFile(@Param("searchField")String searchField);
}
