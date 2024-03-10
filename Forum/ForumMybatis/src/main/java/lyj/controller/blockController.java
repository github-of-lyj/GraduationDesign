package lyj.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import entities.Block;
import entities.PostReply;
import lyj.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/block")
public class blockController {
    @Autowired
    BlockService BlockDAO;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/getAll")
    List<Block> getAllBlock(){
        return BlockDAO.selectAllBlock();
    }

    @GetMapping("/get/{blockID}")
    Block selectBlockByID(@PathVariable("blockID")int blockID){
        return BlockDAO.selectBlockByID(blockID);
    }
}
