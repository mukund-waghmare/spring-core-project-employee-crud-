package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.ty.entity.Employee;

@Component
public class EmployeeDao {
	
	
	EntityManagerFactory entityanagerFactory =null;
	EntityManager entityManager=null;
	EntityTransaction entityTransaction=null;
	
	{
		entityanagerFactory=Persistence.createEntityManagerFactory("vikas");
		entityManager=entityanagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	
	
	public Employee addEmployee(Employee passedEmployee)
	{
		if(passedEmployee!=null)
		{
			entityTransaction.begin();
			entityManager.persist(passedEmployee);
			entityTransaction.commit();
			return passedEmployee;
		}
		
		return null;
		
	}
	
	public List<Employee> displayAllEmployee()
	{
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> employeeList=query.getResultList();
		
		
		return employeeList;
	}
	
	
	public Employee updateEmployee(Employee PassedEmployee,int passedId)
	{
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> employeeList=query.getResultList();
		
		if(employeeList!=null)
		{
			for(Employee employee:employeeList)
			{
				if(employee.getEmployee_Id()==passedId)
				{
					employee.setEmployee_Name(PassedEmployee.getEmployee_Name());
					employee.setEmployee_Designation(PassedEmployee.getEmployee_Designation());
					
					entityTransaction.begin();
					entityManager.merge(employee);
					entityTransaction.commit();
					
					return employee;
					
				}
			}
	
		
		}
		
		return null;
	}
	
	public boolean deleteEmployee(int passedId)
	{
		List<Employee> employeeList=displayAllEmployee();
		
		if(employeeList!=null)
		{
			for(Employee employee:employeeList)
			{
				if(employee.getEmployee_Id()==passedId)
				{
					entityTransaction.begin();
					entityManager.remove(employee);
					entityTransaction.commit();
				}
			}
		}
		
		return false;
	
	}
	
	
	public Employee findEmployeeById(int passedId)
	{
		List<Employee> employeeList=displayAllEmployee();
		
		for(Employee employee:employeeList)
		{
			if(employee.getEmployee_Id()==passedId)
			{
				return employee;
			}
		}
		return null;
	}

}
