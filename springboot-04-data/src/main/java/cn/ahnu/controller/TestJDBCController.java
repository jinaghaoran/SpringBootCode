package cn.ahnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestJDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //    使用JdbcTemplate增删改查
//    查询
    @GetMapping("/QueryList")
    public List<Map<String, Object>> queryList() {
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //    添加数据
    @GetMapping("/addList")
    public String addList() {
        String sql = "INSERT INTO mybatis.user (name, pwd, sex, birthday) VALUES ('21', '33', '33', '2021-11-17')";
        jdbcTemplate.update(sql);
        return "addList";
    }

    //    修改数据
    @GetMapping("updateList/{id}")
    public String updateList(@PathVariable("id") Integer id) {
        String sql = "UPDATE mybatis.user t SET t.name = ? WHERE t.id = " + id;
        Object[] objects = new Object[1];
//        通过数组，将要填入的值放进去，即语句中的name为jhr
        objects[0] = "jhr";
        jdbcTemplate.update(sql, objects);
        return "updateList";
    }

    //    删除数据
    @GetMapping("deleteList/{id}")
    public String deleteList(@PathVariable("id") Integer id) {
//        根据传入的id删除数据
        String sql = "DELETE FROM mybatis.user WHERE id = " + id;
        jdbcTemplate.execute(sql);
        return "deleteList";
    }


}
