package lyj.controller;

import entities.UploadFile;
import jakarta.annotation.Resource;
import lyj.service.SearchFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/UploadFileSearch")
public class UploadFileSearchController {
    @Resource
    SearchFeignService searchService;


    @RequestMapping("/selectVagueUploadFile/{searchField}")
    public List<UploadFile> selectVagueUploadFile(@PathVariable("searchField") String searchField){
        return searchService.selectVagueUploadFile(searchField);
    }
}
