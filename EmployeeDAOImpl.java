package com.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Connector.ConnectionFactory;
import com.DataTransferObject.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Employee> getAllEmployees() 
	{

		ArrayList<Employee> empList=new ArrayList<Employee>();
		try 
		{
			Connection con=ConnectionFactory.reqConnection();
			String query="select * from emp";
			Statement stmt=con.createStatement();

			ResultSet res=stmt.executeQuery(query);

			while(res.next())
			{
				int id=res.getInt(1);
				String name=res.getString(2);
				String dept=res.getString(3);
				int salary=res.getInt(4);

				Employee emp=new Employee(id,name,dept,salary);
				empList.add(emp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return empList;
	}

	@Override
	public Employee getEmployee(int id)
	{

		Employee emp=null;

		try
		{
			Connection con=ConnectionFactory.reqConnection();

			String query="select * from emp where id=?";
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			ResultSet res=prepStmt.executeQuery();
			res.next();
			emp=new Employee(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public boolean insertEmployee(int id, String name, String dept, int salary)
	{
		boolean b=false;
		try
		{
			Connection con=ConnectionFactory.reqConnection();

			String query="insert into emp(`id`,`name`,`dept`,`salary`) values(?,?,?,?)";
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);
			prepStmt.setString(2, name);
			prepStmt.setString(3, dept);
			prepStmt.setInt(4,salary);

			b=prepStmt.execute();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(b)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) 
	{

		int i=0;
		try
		{
			Connection con=ConnectionFactory.reqConnection();

			String query="update emp set salary = ? where id= ? ";
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1,emp.getSalary());
			prepStmt.setInt(2,emp.getId());
			i=prepStmt.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(i==1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		int i=0;
		try
		{
			Connection con=ConnectionFactory.reqConnection();
			String query="delete from emp where id = ?";
			PreparedStatement prepStmt=con.prepareStatement(query);
			prepStmt.setInt(1, id);

			i=prepStmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		if(i==1)
		{
			return true;
		}
		return false;
	}
}
