package lyj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorityMapper {
    String selectUserAuthorityByUserID(@Param("userID")int userID);
}
