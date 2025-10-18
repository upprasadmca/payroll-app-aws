package com.csoft.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.csoft.app.model.Employee;

@Mapper
public interface EmployeeMapper {
	
	@Select("SELECT * FROM EMPLOYEE WHERE ID = #{id}")
	Employee findById(@Param("id") Integer id);

	@Select("SELECT * FROM EMPLOYEE")
	List<Employee> findAll();

	@Insert(value = { "INSERT INTO EMPLOYEE (name, department) VALUES(#{name}, #{department})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Employee employee);
}
