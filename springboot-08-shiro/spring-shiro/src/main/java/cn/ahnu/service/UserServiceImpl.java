package cn.ahnu.service;

import cn.ahnu.mapper.UserMapper;
import cn.ahnu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User QueryUserByName(String name) {
        return userMapper.QueryUserByName(name);
    }
}
