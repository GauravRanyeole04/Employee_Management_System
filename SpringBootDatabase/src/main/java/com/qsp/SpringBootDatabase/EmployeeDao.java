package com.qsp.SpringBootDatabase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeDao {
	@Autowired
	EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
		
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Employee findEmployeeById(int id) {
		Optional<Employee> optional = repository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}
	
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}
	
	public List<Employee> findAllEmployee(){
		return repository.findAll();
	}	
	
	public List<Employee> findEmpByName(String name){
		return repository.findByName(name);
	}
	
	public List<Employee> findBySal(double sal){
		return repository.findBySal(sal);
	}
}
