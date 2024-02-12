package lyj.service;

import entities.Block;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "forum-mybatis")
public interface ForumFeignService {
    @GetMapping("/block/getAll")
    List<Block> getAllBlock();

    @GetMapping("/block/get/{blockID}")
    Block selectBlockByID(@PathVariable("blockID")int blockID);
}
