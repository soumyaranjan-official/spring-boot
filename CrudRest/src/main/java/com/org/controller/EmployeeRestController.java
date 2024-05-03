package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.EmployeeDao;
import com.org.dto.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeDao dao;
	
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return dao.saveEmployee(employee);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> fetchEmployeeId(@PathVariable int id) {

		return dao.fetchEmployeeId(id);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> fetchAllEmployee() {
		return dao.fetchAllEmployee();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int id) {
		return dao.deleteEmployeeById(id);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateById(@PathVariable int id, @RequestBody Employee employee) {
		return dao.updateById(id, employee);
	}

	@GetMapping("/{email}/{password}")
	public ResponseEntity<List<Employee>> getEmployeeByEmailAndPassword(@PathVariable String email,
			@PathVariable String password) {

		return dao.getEmployeeByEmailAndPassword(email, password);
	}

	@GetMapping("/byName/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name) {

		return dao.getEmployeeByName(name);
	}

	@GetMapping("/byName/byPassword/{name}/{password}")
	public ResponseEntity<List<Employee>> getEmployeeByNameAndPassword(@PathVariable String name,
			@PathVariable String password) {
		return dao.getEmployeeByNameAndPassword(name, password);
	}

	@GetMapping("/byStartLetter/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByStartingName(@PathVariable String name) {
		return dao.getEmployeeByStartingName(name);
	}

	@GetMapping("/byEndLetter/like/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByEndingName(@PathVariable String name) {
		return dao.getEmployeeByEndingName1(name);
	}

	@GetMapping("/byAge/{age}")
	public ResponseEntity<List<Employee>> getEmployeeByAgeLessThan(@PathVariable int age) {
		return dao.getEmployeeByAgeLessThan(age);
	}

	@GetMapping("/byAge/greater/{age}")
	public ResponseEntity<List<Employee>> getEmployeeByAgeGreaterThanEqual(@PathVariable int age) {
		return dao.getEmployeeByAgeGreaterThanEqual(age);

	}

	@GetMapping("/bySalary/{salary}")
	public ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThan(@PathVariable long salary) {
		return dao.getEmployeeBySalaryGreaterThan(salary);
	}
	
	@GetMapping("bySalary/range/{sal1}/{sal2}") 
	public ResponseEntity<List<Employee>> getEmployeeBySalaryBetweenRange(@PathVariable("sal1") long minSal,@PathVariable("sal2") long maxSal){
		return dao.getEmployeeBySalaryBetweenRange(minSal,maxSal);
	}
	
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		return dao.getAllEmployee();
	}
}
