package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MySecondJDBCWithProperties {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		FileReader reader =null;

		try {

			reader = new  FileReader("Dbsecond.properties");
			Properties prop = new Properties();
			prop.load(reader);

			//Step 1 Load the Driver

			Class.forName(prop.getProperty("driver-class-name"));

			//Step 2 Get the connection
			String url = prop.getProperty("url");
			//for specify the database location
			conn = DriverManager.getConnection(url,prop);      			 //it returns the connection(I) type object, it is and example 
			//																	   for abstraction because we don't know which class is implementing that interface but we get the functionality
			//step3 Issue Sql query
			stmt = conn.createStatement();
			String sql =prop.getProperty( "select-query");
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
		} catch (Exception e) {

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
				if(reader!=null) {
					reader.close();
				}
			}catch (Exception e) {

				e.printStackTrace();
			}

		}

	}


}

