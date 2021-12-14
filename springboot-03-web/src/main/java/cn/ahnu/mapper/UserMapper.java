package cn.ahnu.mapper;

import cn.ahnu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
//    根据username，查询对应密码
    User getUserByName(String username);
}
