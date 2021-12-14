package cn.ahnu.mapper;

import cn.ahnu.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
//    获取所有员工
    List<Employee> getAll();
//    id查询
    Employee getEmployeeById(int id);
//   添加
//    int addEmployee(Employee employee);
    int save(Employee employee);
//    修改
    int updateEmp(Employee employee);
//    删除
    int delete(int id);
}
