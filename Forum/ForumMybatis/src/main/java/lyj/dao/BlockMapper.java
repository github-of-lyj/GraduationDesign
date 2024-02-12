package lyj.dao;

import entities.Block;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlockMapper {
    List<Block> selectAllBlock();

    Block selectBlockByID(@Param(value = "blockID")int blockID);
}
