package lyj.controller;

import entities.UploadFile;
import lyj.service.UploadFileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UploadFileSearch")
public class UploadFileSearchController {

    @Autowired
    UploadFileSearchService uploadFileSearchDAO;

    @RequestMapping("/selectVagueUploadFile/{searchField}")
    public List<UploadFile> selectVagueUploadFile(@PathVariable("searchField") String searchField){
        return uploadFileSearchDAO.selectVagueUploadFile(searchField);
    }
}
