package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private final EmployeeService employeeservice;

	public EmployeeController(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}

	@PostMapping
	public void addEmployee(@RequestBody Employee employee){
		employeeservice.addEmployee(employee);
	}

	@GetMapping(path = "{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Integer id){
		return employeeservice.getEmployeeById(id);
	}

	@GetMapping
	public List<Employee> getEmployeeByAsc(){
		return employeeservice.getEmployeeByAsc();
	}

	@PutMapping(path = "{id}")
	public void updateEmployeeSalary(@PathVariable("id") Integer id,@RequestParam Double salary){
		employeeservice.updateEmployeeSalary(id,salary);
	}

}
