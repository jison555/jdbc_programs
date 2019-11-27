package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class ExecuteUpdateQuery {

	public static void main(String[] args) {

		Connection conn= null;
		Statement stmt = null;

		try {

			//Step 1 Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			//Step 2 get the Connection

			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);

			//step 3 Issue sql statement

			String sql="update employee_info set name='abc', sal=50 where id=3";
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);

			//Step 4 read the result

			System.out.println(count +" row affected");


		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}





	}

}
