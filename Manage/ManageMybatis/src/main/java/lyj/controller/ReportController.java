package lyj.controller;

import entities.Report;
import lyj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @PostMapping("/insertNewReport")
    public int insertNewReport(@RequestBody Report reportData){
        return reportService.insertNewReport(reportData);
    }

    @GetMapping("/selectReport/{searchField}")
    public List<Report> selectReport(@PathVariable("searchField") String searchField){
        return reportService.selectReport(searchField);
    }
}
