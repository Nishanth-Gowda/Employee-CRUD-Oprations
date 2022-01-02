package com.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.entity.Employee;
import com.repository.EmployeeRepository;

import javax.transaction.Transactional;

@Component
public class EmployeeService {
	@Autowired
	private final EmployeeRepository employeerepository;

	public EmployeeService(EmployeeRepository employeerepository) {
		this.employeerepository = employeerepository;
	}

	public void addEmployee(Employee employee) {
		Optional<Employee> employeeOptional = employeerepository.findEmployeeById(employee.getId());
		if(employeeOptional.isPresent()){
			throw new IllegalArgumentException("Id taken");
		}
		employeerepository.save(employee);
	}


	@Transactional
	public void updateEmployeeSalary(Integer id, Double salary) {
			Employee employee = employeerepository.findEmployeeById(id).orElseThrow(() -> new IllegalArgumentException("Employee with id"+id+ "doesnot exist"));
			if(salary>0){
				employee.setSalary(salary);
			}else {
				throw new IllegalArgumentException("Salary should be greater than zero");
			}
	}


	public Optional<Employee> getEmployeeById(Integer id) {
		return employeerepository.findEmployeeById(id);
	}

	public List<Employee> getEmployeeByAsc() {
		return employeerepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
}
