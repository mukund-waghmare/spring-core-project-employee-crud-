package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value = "prototype")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_Id;
	
	private String employee_Name;
	
	private String employee_Designation;
	
	private double employee_Salary;

	public int getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getEmployee_Name() {
		return employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}

	public String getEmployee_Designation() {
		return employee_Designation;
	}

	public void setEmployee_Designation(String employee_Designation) {
		this.employee_Designation = employee_Designation;
	}

	public double getEmployee_Salary() {
		return employee_Salary;
	}

	public void setEmployee_Salary(double employee_Salary) {
		this.employee_Salary = employee_Salary;
	}

	public Employee(int employee_Id, String employee_Name, String employee_Designation, double employee_Salary) {
		
		this.employee_Id = employee_Id;
		this.employee_Name = employee_Name;
		this.employee_Designation = employee_Designation;
		this.employee_Salary = employee_Salary;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name=" + employee_Name + ", employee_Designation="
				+ employee_Designation + ", employee_Salary=" + employee_Salary + "]";
	}
	
	
	
	
	

}
