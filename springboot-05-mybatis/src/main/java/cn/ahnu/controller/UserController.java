package cn.ahnu.controller;

import cn.ahnu.mapper.UserMapper;
import cn.ahnu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/queryList")
    public List<User> queryList() {
        List<User> userList = userMapper.queryList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") int id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @GetMapping("/addUser")
    public int addUser(User user) {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(ft.format(date));
        user = new User(1, "jhr", "jhr", "男", date);
        int i = userMapper.addUser(user);
        return i;
    }

    @GetMapping("/updateUser")
    public int UpdateUser(User user) {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(ft.format(date));
        user = new User(5, "jhr", "jhr", "男", date);
        int i = userMapper.updateUser(user);
        return i;
    }

    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id") int id) {
        int i = userMapper.deleteUser(id);
        return i;
    }


}
