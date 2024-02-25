package lyj.dao;

import entities.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    int insertNewReport(@Param("report")Report report);

    List<Report> selectReport(@Param("searchField")String searchField);
}
