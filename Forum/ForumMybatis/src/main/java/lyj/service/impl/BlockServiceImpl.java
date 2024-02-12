package lyj.service.impl;

import entities.Block;
import lyj.dao.BlockMapper;
import lyj.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockMapper BlockDAO;


    @Override
    public List<Block> selectAllBlock() {
        return BlockDAO.selectAllBlock();
    }

    @Override
    public Block selectBlockByID(int blockID) {
        return BlockDAO.selectBlockByID(blockID);
    }
}
