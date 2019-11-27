package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;



public class MyThirdJDBCWithProperties {

	public static void main(String[] args) {

		Connection conn= null;
		PreparedStatement pstmt = null;
		
			

		try {
			FileReader reader=new FileReader("Dbsecond.properties");
			Properties prop=new Properties();
			prop.load(reader);
			

			//Step 1 Load the Driver
			Class.forName(prop.getProperty("driver-class-name"));
			//Step 2 get the Connection

			String url=prop.getProperty("url");
			conn=DriverManager.getConnection(url,prop);

			//step 3 Issue sql statement

			String sql="update-query";
			pstmt=conn.prepareStatement(sql);
			
			String empid=args[3];
			int id = Integer.parseInt(empid);
			
			String ename=args[0];
			
			String empsal = args[1];
			int sal=Integer.parseInt(empsal); 
			
			String empgender = args[2];
	
			
			pstmt.setInt(4,id);
			pstmt.setString(1,ename);
			pstmt.setInt(2, sal);
			pstmt.setString(3,empgender);
			
			
			
			int count=pstmt.executeUpdate();

			//Step 4 read the result

			System.out.println(count +" row affected");


		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}

			}catch (Exception e) {
				e.printStackTrace();
			}
		}





	}

}
