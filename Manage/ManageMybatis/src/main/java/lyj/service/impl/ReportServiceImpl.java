package lyj.service.impl;

import entities.Report;
import lyj.dao.ReportMapper;
import lyj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportMapper reportDAO;

    @Override
    public int insertNewReport(Report report) {
        reportDAO.insertNewReport(report);
        return report.getReportID();
    }

    @Override
    public List<Report> selectReport(String searchField) {
        return reportDAO.selectReport(searchField);
    }
}
