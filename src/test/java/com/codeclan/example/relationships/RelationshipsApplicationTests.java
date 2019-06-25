package com.codeclan.example.relationships;

import com.codeclan.example.relationships.models.Department;
import com.codeclan.example.relationships.models.Employee;
import com.codeclan.example.relationships.models.Project;
import com.codeclan.example.relationships.repositories.DepartmentRepository;
import com.codeclan.example.relationships.repositories.EmployeeRepository;
import com.codeclan.example.relationships.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipsApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;



	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllEmployees(){
		Department hr = new Department("hr");
		departmentRepository.save(hr);

		Employee Bob = new Employee("Bob", "Newhart", 123456, hr);
		employeeRepository.save(Bob);

		Project Rory = new Project(5);
		projectRepository.save(Rory);

		Rory.addEmployeeToList(Bob);
		projectRepository.save(Rory);
	}

}
