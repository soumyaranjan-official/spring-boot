package com.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.org.dto.Employee;
import com.org.repo.EmployeeRepository;

@Component
public class EmployeeDao {

	@Autowired
	private EmployeeRepository repo;

	public ResponseEntity<Employee> saveEmployee(Employee employee) {
		Employee save = repo.save(employee);
		return new ResponseEntity<Employee>(save, HttpStatus.OK);
	}

	public ResponseEntity<Employee> fetchEmployeeId(int id) {

		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return new ResponseEntity<Employee>(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<Employee>> fetchAllEmployee() {
		return new ResponseEntity<List<Employee>>(repo.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<Employee> deleteEmployeeById(int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {

			repo.deleteById(id);
			return new ResponseEntity<Employee>(optional.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Employee> updateById(int id, Employee employee) {

		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			employee.setEid(id);

			Employee save = repo.save(employee);
			return new ResponseEntity<Employee>(save, HttpStatus.OK);

		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<Employee>> getEmployeeByEmailAndPassword(String email, String password) {
		List<Employee> list = repo.findByEmailAndPassword(email, password);

		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeByName(String name) {
		List<Employee> list = repo.findByName(name);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeByNameAndPassword(String name, String password) {
		List<Employee> list = repo.findByNameAndPassword(name, password);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeByStartingName(String name) {

		List<Employee> list = repo.findByNameStartingWith(name);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeByEndingName1(String name) {
		List<Employee> list = repo.findByNameEndingWith(name);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeByAgeLessThan(int age) {
		List<Employee> list = repo.findByAgeLessThan(age);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeByAgeGreaterThanEqual(int age) {
		List<Employee> list = repo.findByAgeGreaterThanEqual(age);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThan(long salary) {
		List<Employee> list = repo.getEmployeeBySalaryGreaterThan(salary);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getEmployeeBySalaryBetweenRange(long minSal, long maxSal) {
		List<Employee> list = repo.getEmployeeBySalaryBetweenRange(minSal, maxSal);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

	}

	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = repo.getEmployee();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	}
