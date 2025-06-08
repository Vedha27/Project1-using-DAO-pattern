package com.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	static String url="jdbc:mysql://localhost:3306/Employee";
	static String un="root";
	static String pwd="Vedha@276";
	static Connection con=null;
	
	public static Connection reqConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,un,pwd);
		
		return con;
	}
}
