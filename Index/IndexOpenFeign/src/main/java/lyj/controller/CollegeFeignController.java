package lyj.controller;

import entities.College;
import jakarta.annotation.Resource;
import lyj.service.IndexFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/college")
public class CollegeFeignController {
    @Resource
    private IndexFeignService indexService;

    @RequestMapping("/random")
    College getRandomCollege(){
        return indexService.getRandomCollege();
    }
}
