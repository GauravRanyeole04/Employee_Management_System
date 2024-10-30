package com.qsp.SpringBootDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public ResponseEntity<ResponseStucture<Employee>> saveEmployee(Employee employee){
		dao.saveEmployee(employee);
		ResponseStucture<Employee> responseStucture = new ResponseStucture<Employee>();
		responseStucture.setStatusCode(201);
		responseStucture.setMessage("created");
		responseStucture.setData(employee);
		return new ResponseEntity<ResponseStucture<Employee>>(responseStucture,HttpStatus.CREATED);
	}
}
