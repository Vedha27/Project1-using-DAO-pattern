package com.DataAccessObject;

import java.util.List;

import com.DataTransferObject.Employee;

public interface EmployeeDAO {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(int id);
	
	boolean insertEmployee(int id,String name,String dept,int salary);
	
	boolean updateEmployee(Employee e);
	
	boolean deleteEmployee(int di);

}
