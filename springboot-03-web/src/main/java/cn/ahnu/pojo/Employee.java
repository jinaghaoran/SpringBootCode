package cn.ahnu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private int gender;
//    private int departmentId;
    private Date birth;
    private String departmentName;
    private Department department;

//    public Employee(int id, String lastName, String email, int gender, Department department) {
//        this.id = id;
//        this.lastName = lastName;
//        this.email = email;
//        this.gender = gender;
//        this.department = department;
//        this.birth = new Date();
//    }
public Employee(String lastName, String email, int gender,String departmentName,Date birth) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
//       this.departmentId = departmentId;
       this.departmentName = departmentName;
        this.birth = birth;
    }
    public Employee(int id,String lastName, String email, int gender,String departmentName,Date birth) {
        this.id=id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
//       this.departmentId = departmentId;
       this.departmentName = departmentName;
        this.birth = birth;
    }
}
