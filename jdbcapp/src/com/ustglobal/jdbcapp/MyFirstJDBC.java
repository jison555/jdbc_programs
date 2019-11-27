package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import java.sql.Statement;

public class MyFirstJDBC {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			//Step 1 Load the Driver

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			//Step 2 Get the connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?" 
										+"user=root&password=root";  //for specify the database location
			conn = DriverManager.getConnection(url);      			 //it returns the connection(I) type object, it is and example 
 //																	   for abstraction because we don't know which class is implementing that interface but we get the functionality
			//step3 Issue Sql query
			stmt = conn.createStatement();
			String sql = "select * from employee_info";
			rs=stmt.executeQuery(sql);
			
			
			//step 4 Read the result
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("sal");
				String gender = rs.getString("gender");
				

				System.out.println("id = " + id);
				System.out.println("name = " + name);
				System.out.println("sal = " + sal);
				System.out.println("gender = " + gender);
				System.out.println("**************************");

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			
			//step 5  Close all JDBC Objects
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

}
