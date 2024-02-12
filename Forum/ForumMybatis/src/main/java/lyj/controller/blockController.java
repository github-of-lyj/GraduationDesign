package lyj.controller;

import entities.Block;
import lyj.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/block")
public class blockController {
    @Autowired
    BlockService BlockDAO;

    @GetMapping("/getAll")
    List<Block> getAllBlock(){
        return BlockDAO.selectAllBlock();
    }

    @GetMapping("/get/{blockID}")
    Block selectBlockByID(@PathVariable("blockID")int blockID){
        return BlockDAO.selectBlockByID(blockID);
    }




}
