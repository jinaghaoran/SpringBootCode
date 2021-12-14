package cn.ahnu;

import cn.ahnu.mapper.DepartmentMapper;
import cn.ahnu.mapper.EmployeeMapper;
import cn.ahnu.pojo.Department;
import cn.ahnu.pojo.Employee;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@SpringBootTest
class Springboot03WebApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeMapper employeeMapper;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    void contextLoads() throws Exception{
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        DruidDataSource druidDataSource =(DruidDataSource) dataSource;
        System.out.println(druidDataSource.getMaxActive());
        connection.close();
    }

    @Test
    public void testGetStudents() throws ParseException {
//       多表查询测试
        List<Employee> all = employeeMapper.getAll();
        System.out.println(all);
//        id查询测试
        System.out.println(employeeMapper.getEmployeeById(1));

//        添加语句测试
        System.out.println(employeeMapper.save(new Employee("e", "123@12.com", 1, "开发部", simpleDateFormat.parse("1999-12-3"))));

//  删除
//        System.out.println(employeeMapper.delete(4));
    }

    @Autowired
    DepartmentMapper departmentMapper;
    @Test
    public void TestDepartmentMapper() throws ParseException {
//        System.out.println(departmentMapper.getDepartments());
        int i = employeeMapper.updateEmp(new Employee(14, "jhr2", "123@12.com", 0, "开发部", simpleDateFormat.parse("1999-12-4")));
        System.out.println(i);
    }


}
