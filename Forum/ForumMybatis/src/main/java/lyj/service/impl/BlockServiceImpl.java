package lyj.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import entities.Block;
import lyj.dao.BlockMapper;
import lyj.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master")
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockMapper BlockDAO;


    @Override
    @DS("slave")
    public List<Block> selectAllBlock() {
        return BlockDAO.selectAllBlock();
    }

    @Override
    @DS("slave")
    public Block selectBlockByID(int blockID) {
        return BlockDAO.selectBlockByID(blockID);
    }
}
