package lyj.service;

import entities.Report;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportService {
    int insertNewReport(Report report);

    List<Report> selectReport(String searchField);
}
