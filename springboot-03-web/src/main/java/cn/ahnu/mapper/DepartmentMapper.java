package cn.ahnu.mapper;

import cn.ahnu.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    List<Department> getDepartments();
}
