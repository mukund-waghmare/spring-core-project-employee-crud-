package com.ty.driver;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.dao.EmployeeDao;
import com.ty.entity.Employee;

public class EmployeeDriver {

	static boolean runApp=true;
	
	@Autowired
	static Scanner sccannerObject;
	
	@Autowired
	static Employee employee;
	
	@Autowired
	static EmployeeDao employeeDao;
	
	
	static ConfigurableApplicationContext context;
			
    static {
    	context=new AnnotationConfigApplicationContext(Config.class);

	}
	
	
	
	public static void main(String[] args) {
		
		
		
		sccannerObject=(Scanner) context.getBean("scanner");
		
		employeeDao=(EmployeeDao) context.getBean("employeeDao");
		
		while(runApp)
		{
			switch(runChoice())
			{
			case 1:{
				 addEmployee();
			}
			break;
			case 2:{
				displayAllEmployees();
			}
			break;
			case 3:{
				 updateEmployee();
			}
			break;
			case 4:{
				deleteEmployee();
			}
			break;
			case 5:{
				findEmployeeById();
			}
			break;
			case 6:{
				exite();
			}
			break;
			default:{
				defaultRunOption();
			}
			break;
			}
			
		}
	}
	
	
	
	private static void findEmployeeById()
	{
		System.out.println("==================================================================");
		
		System.out.println("Enter The Employee ID To Find");
		int id=sccannerObject.nextInt();
		
		Employee employee=employeeDao.findEmployeeById(id);
		
		if(employee!=null)
		{
			System.out.println("==================================================================");
			
			System.out.println(employee);
			System.out.println("==================================================================");
			
		}
		else
		{
			System.out.println("==================================================================");
			
			System.out.println("Employee Dosnot Exist For Id : "+id);
			System.out.println("==================================================================");
			
		}
		
		
	}
	
	
	private static void defaultRunOption() {
		
		System.out.println("==================================================================");
		
		System.out.println("Plz Enter VAlid Choice");
		
		System.out.println("==================================================================");
		
		
		
	}


	private static void exite() {
		runApp=false;
		System.out.println("=============================Exite Successfull=========================================");
		
	}


	private static void deleteEmployee() {
		System.out.println("==================================================================");
		
		System.out.println("Enter the Employee Id To Update");
		int idToDelete=sccannerObject.nextInt();
		
		boolean deletedStatus=employeeDao.deleteEmployee(idToDelete);
		if(deletedStatus)
		{
			System.out.println("==================================================================");
			
			System.out.println("Employee Deleted Successfully");
			
			System.out.println("==================================================================");
			
		}
		else
		{
			System.out.println("==================================================================");
			
			System.out.println("Employee Not Found For Id  : "+idToDelete);
			
			System.out.println("==================================================================");
			
		}
		
	}


	private static void updateEmployee() {
		
		System.out.println("==================================================================");
		
		employee=(Employee) context.getBean("employee");
		
		
		System.out.println("Enter Employee ID To Update Infromation");
		int oldId=sccannerObject.nextInt();
		
		System.out.println("Enter the Employee new Name");
		String name=sccannerObject.next();
		
		System.out.println("Enter the new Employee Designation");
		String designation=sccannerObject.next();
		
		employee.setEmployee_Designation(designation);
		employee.setEmployee_Name(name);
		
		Employee updatedEmployee=employeeDao.updateEmployee(employee, oldId);
		
		if(updatedEmployee!=null)
		{
			System.out.println("======================================================================");
			System.out.println("Employee Updated Successfully");
			System.out.println("======================================================================");
			
		}
		else
		{
			System.out.println("======================================================================");
			
			System.out.println("Employee Not Found with Id : "+oldId);
		    
			System.out.println("======================================================================");
			
		}
		
		
	}


	private static void displayAllEmployees() {
		System.out.println("==================================================================");
		
		List<Employee> employeeList=employeeDao.displayAllEmployee();
		
		for(Employee employee:employeeList)
		{
			System.out.println("======================================================================");
			System.out.println(employee);
			System.out.println("======================================================================");
			
		}
	}


	private static void addEmployee() {
		
		System.out.println("==================================================================");
		
		// ConfigurableApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		employee=(Employee) context.getBean("employee");
		
		
		System.out.println("Enter The Employee Name");
		String name=sccannerObject.next();
		
		System.out.println("Enter The Employee Designation");
		String designation=sccannerObject.next();
		
		System.out.println("Enter The Employee Salary");
		double salary=sccannerObject.nextDouble();
		
	
		employee.setEmployee_Name(name);
		employee.setEmployee_Designation(designation);
		employee.setEmployee_Salary(salary);
		
		Employee employeeResult=employeeDao.addEmployee(employee);
		
		if(employeeResult!=null)
		{
			System.out.println("==================================================================");
			System.out.println("Employee Added Successfully");

			System.out.println("==================================================================");
	
		}
		else
		{

			System.out.println("==================================================================");
			System.out.println("Plz Enter All  Infromation Of Employee");
			System.out.println("==================================================================");
		}

	}


	public static int runChoice()
	{
		System.out.println("======================================================================");
		
		System.out.println("Enter The Choice\n1:Add Employee\n2:DisplayAll Employee\n3:Update Employee\n4:Delete Employee\n5:Find Employee By Id\n6:Exite");
	    int choice=sccannerObject.nextInt();
	    System.out.println("======================================================================");
		
	    
	    return choice;
	}
}
