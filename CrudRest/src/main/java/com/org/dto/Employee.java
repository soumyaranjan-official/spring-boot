package com.org.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="employee")
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;

	@Column(name="name",nullable =false,length =50)
	private String name;
	
	@Column(name="city",nullable =false,length =50)
	private String city;
	
	@Column(name="age",nullable =false,length =3)
	private int age;
	
	@Column(name="mobile",nullable =false,unique = true,length =10)
	private long mobile;

	@Column(name="email",nullable =false,unique = true,length =50)
	private String email;

	@Column(name="password",nullable =false,length =10)
	private String password;
	
	@Column(name="salary",nullable =false,length =50)
	private long salary;

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String name, String city, int age, long mobile, String email, String password,
			long salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.city = city;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.salary = salary;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
