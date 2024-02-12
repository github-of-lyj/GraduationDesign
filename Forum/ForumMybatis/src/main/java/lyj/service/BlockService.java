package lyj.service;

import entities.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockService {
    List<Block> selectAllBlock();

    Block selectBlockByID(int blockID);
}
