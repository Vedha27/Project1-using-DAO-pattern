package com.Main;

import java.util.List;
import java.util.Scanner;

import com.DataAccessObject.EmployeeDAOImpl;
import com.DataTransferObject.Employee;

public class Main {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);


		EmployeeDAOImpl empDAOimp=new EmployeeDAOImpl();

		List<Employee> list=empDAOimp.getAllEmployees();
		System.out.println("--------------Welcome to Vedhantra Technologies pvt.Ltd----------");
		System.out.println("List Of Employees");
		for(Employee e:list)
		{
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("Enter details of Employee to insert: ");
		String details=scan.nextLine();
		String arr[]=details.split(" ");
		int insertId=Integer.parseInt(arr[0]);
		String name=arr[1];
		String dept=arr[2];
		int salary=Integer.parseInt(arr[3]);
		System.out.println(empDAOimp.insertEmployee(insertId, name, dept, salary));
		System.out.println("After insertion the new list of Employees");

		list=empDAOimp.getAllEmployees();

		for(Employee e:list)
		{
			System.out.println(e);
		}
		System.out.println();
		System.out.print("Enter Employee ID to update: ");
		int id=scan.nextInt();

		Employee e=empDAOimp.getEmployee(id);
		System.out.println("Before updating: "+e);

		System.out.print("Enter salary to update");
		int newSalary=scan.nextInt();
		e.setSalary(newSalary);

		System.out.println(empDAOimp.updateEmployee(e));

		System.out.println("After updation: "+e);
	

		System.out.print("Enter Employee ID to Delete: "); 
		id=scan.nextInt();

		System.out.println(empDAOimp.deleteEmployee(id));
		System.out.println();

		System.out.println("After performing Deletion the Employee List");

		list=empDAOimp.getAllEmployees();

		for(Employee emp:list)
		{
			System.out.println(emp);
		}
	}
}
