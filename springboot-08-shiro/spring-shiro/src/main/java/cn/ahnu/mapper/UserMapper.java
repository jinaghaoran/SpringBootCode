package cn.ahnu.mapper;

import cn.ahnu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public User QueryUserByName(String name);
}
