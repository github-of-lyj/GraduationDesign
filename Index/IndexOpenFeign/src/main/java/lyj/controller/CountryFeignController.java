package lyj.controller;

import entities.Country;
import jakarta.annotation.Resource;
import lyj.service.IndexFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/country")
public class CountryFeignController {
    @Resource
    IndexFeignService indexService;

    @RequestMapping("/{type}/{limit}")
    List<Country> getCountriesByType(@PathVariable("type") String type, @PathVariable("limit") int limit){
        return indexService.getCountriesByType(type,limit);
    }
}
