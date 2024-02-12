package lyj.controller;

import entities.Block;
import jakarta.annotation.Resource;
import lyj.service.ForumFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/block")
public class BlockController {
    @Resource
    ForumFeignService forumService;


    @GetMapping("/getAll")
    List<Block> getAllBlock(){
        return forumService.getAllBlock();
    }


    @GetMapping("/get/{blockID}")
    Block selectBlockByID(@PathVariable("blockID")int blockID){
        return forumService.selectBlockByID(blockID);
    }
}
