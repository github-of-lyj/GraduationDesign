package lyj.controller;

import entities.Report;
import jakarta.annotation.Resource;
import lyj.service.ManageFeignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/Report")
public class ReportController {

    @Resource
    ManageFeignService manageService;

    @PostMapping("/insertNewReport")
    public int insertNewReport(@RequestBody Report reportData){
        return manageService.insertNewReport(reportData);
    }

    @GetMapping("/selectReport/{searchField}")
    public List<Report> selectReport(@PathVariable("searchField") String searchField){
        return manageService.selectReport(searchField);
    }
}
