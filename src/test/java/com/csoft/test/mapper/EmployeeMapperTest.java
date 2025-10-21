package com.csoft.test.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import com.csoft.app.PersistanceConfig;
import com.csoft.app.mapper.EmployeeMapper;
import com.csoft.app.model.Employee;

@SpringBootTest(classes = com.csoft.app.PayrollApp.class)
public class EmployeeMapperTest {

	@Autowired
	EmployeeMapper employeeMapper;

	@Test
	public void whenRecordsInDatabase_shouldReturnEmployeeWithId() {
		Employee employee = employeeMapper.findById(1);
		assertNotNull(employee);
		assertThat(employee.getId().intValue()).isEqualTo(1);
	}
}
