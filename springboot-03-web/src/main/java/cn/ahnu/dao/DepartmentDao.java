package cn.ahnu.dao;

import cn.ahnu.pojo.Department;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<>();
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "营销部"));
        departmentMap.put(103, new Department(103, "学习部"));
        departmentMap.put(104, new Department(104, "外宣部"));
    }

    //    获取所有信息
    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }

    //id获取
    public Department getDepartmentById(int id) {
        return departmentMap.get(id);
    }

}
