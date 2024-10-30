package com.qsp.SpringBootDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<ResponseStucture<Employee>> saveEmployeeWithResponse(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping("/emp")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return dao.saveEmployee(employee);
	}

	@PutMapping("/emp")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return dao.updateEmployee(employee);
	}

	@GetMapping("/emp/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return dao.findEmployeeById(id);
	}

	@DeleteMapping("/emp/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		if (dao.findEmployeeById(id) != null) {
			dao.deleteEmployeeById(id);
			return "Employee Deleted";
		} else {
			return "Given Employee is not presented";
		}
	}

	@GetMapping("/emp")
	public List<Employee> findAll() {
		return dao.findAllEmployee();
	}
	
	@GetMapping("/emp/name")
	public List<Employee> findByName(@RequestParam String name){
		return dao.findEmpByName(name);
	}
	
	@GetMapping("/emp/sal")
	public List<Employee> findBySal(@RequestParam double sal){
		return dao.findBySal(sal);
	}
}
