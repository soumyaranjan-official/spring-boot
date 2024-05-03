package com.org.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByEmailAndPassword(String email, String password);
	
	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndPassword(String name, String password);
	
	List<Employee> findByNameStartingWith(String prefix);
	
	List<Employee> findByNameEndingWith(String suffix);

	 	
	List<Employee> findByAgeLessThan(int age);
	
	List<Employee> findByAgeGreaterThanEqual(int age);
		
	@Query("select e from Employee e where e.name=:n and e.city=:c")
	List<Employee> getEmployeeByNameAndCity(@Param("n") String name,@Param("c") String city);
	
	@Query("select e from Employee e where e.salary>=:n")
	List<Employee> getEmployeeBySalaryGreaterThan(@Param("n") long salary);
	
	@Query("select e from Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
	List<Employee> getEmployeeBySalaryBetweenRange(@Param("minSalary") long minSal,@Param("maxSalary") long maxSal);

	@Query(value = "select * from employee",nativeQuery = true)
	List<Employee> getEmployee();

	
	
}
