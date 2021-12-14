package cn.ahnu.controller;


import cn.ahnu.mapper.DepartmentMapper;
import cn.ahnu.mapper.EmployeeMapper;
import cn.ahnu.pojo.Department;
import cn.ahnu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeDao;
    @Autowired
    DepartmentMapper departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        System.out.println("list=>>");
        List<Employee> employees = employeeDao.getAll();
        System.out.println(employees);
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //    跳转添加页面,跳转至emp/add.html，Get方法提交
    @GetMapping("/emp")
    public String addTo(Model model) {
//        查询部门
        Collection<Department> departments = departmentDao.getDepartments();
        System.out.println(departments);
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    //    POST方法提交,提交添加数据
    @PostMapping("/emp")
    public String addList(Employee employee) {
        System.out.println("addList->save" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //    修改数据,携带id，使用@PathVariable占位符
    @GetMapping("/emp/{id}")
    public String toUpd(@PathVariable("id") Integer id, Employee employee, Model model) {
        Employee employeeById = employeeDao.getEmployeeById(id);
//        需要查询所在的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("empId", employeeById);
        return "emp/update";
    }

    //    提交修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
        return "redirect:/emps";
    }

    //    删除,restful
    @GetMapping("/delemp/{id}")
    public String del(@PathVariable("id") Integer id, Model model) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    //    注销
    @GetMapping("/user/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("loginUser");
        return "index";
    }

}
