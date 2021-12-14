//package cn.ahnu.dao;
//
//import cn.ahnu.pojo.Department;
//import cn.ahnu.pojo.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//public class EmployeeDao {
//    private static Map<Integer, Employee> employeeDaoMap = null;
//    @Autowired
//    private DepartmentDao departmentDao;
//
//    static {
//        employeeDaoMap = new HashMap<>();
//        employeeDaoMap.put(101, new Employee(101, "jhr", "a123@a123.com", 1, new Department(101, "教学部")));
//        employeeDaoMap.put(102, new Employee(102, "af", "123@123.com", 1, new Department(102, "学习部")));
//        employeeDaoMap.put(103, new Employee(103, "cc", "123as@d123.com", 1, new Department(103, "营销部")));
//        employeeDaoMap.put(104, new Employee(104, "bba", "123dd@g123.com", 1, new Department(104, "教学部")));
//    }
//
//    //主键自增
//    private static Integer ininId = 105;
//
//    //增加一个员工
//    public void save(Employee employee) {
//        if (employee.getId() == null) {
//            employee.setId(ininId++);
//        }
//        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
//        employeeDaoMap.put(employee.getId(), employee);
//    }
//
//    // 查询全部员工信息
//    public Collection<Employee> getAll() {
//        return employeeDaoMap.values();
//    }
//
//    // 通过id查询员工
//    public Employee getEmployeeById(Integer id) {
//        return employeeDaoMap.get(id);
//    }
//
//    //删除员工通过id
//    public void delete(Integer id) {
//        employeeDaoMap.remove(id);
//    }
//}