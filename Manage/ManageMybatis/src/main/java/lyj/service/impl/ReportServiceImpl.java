package lyj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import entities.Report;
import lyj.dao.ReportMapper;
import lyj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportMapper reportDAO;

    @Override
    public int insertNewReport(Report report) {
        reportDAO.insertNewReport(report);
        return report.getReportID();
    }

    @Override
    @DS("slave")
    public List<Report> selectReport(String searchField) {
        return reportDAO.selectReport(searchField);
    }
}
