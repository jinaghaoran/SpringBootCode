package cn.ahnu.service;

import cn.ahnu.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User QueryUserByName(String name);
}
