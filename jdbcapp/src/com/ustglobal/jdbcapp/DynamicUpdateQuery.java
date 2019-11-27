package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;



public class DynamicUpdateQuery {

	public static void main(String[] args) {

		Connection conn= null;
		PreparedStatement pstmt = null;

		try {

			//Step 1 Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			//Step 2 get the Connection

			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);

			//step 3 Issue sql statement

			String sql="update employee_info set name=?, sal=? , gender=? where id=?";
			pstmt=conn.prepareStatement(sql);
			
			String empid=args[0];
			int id = Integer.parseInt(empid);
			
			String ename=args[1];
			
			String empsal = args[2];
			int sal=Integer.parseInt(empsal); 
			
			String empgender = args[3];
	
			
			pstmt.setInt(4,id);
			pstmt.setString(1,ename);
			pstmt.setInt(2, sal);
			pstmt.setString(3,empgender);
			
			
			
			int count=pstmt.executeUpdate();

			//Step 4 read the result

			System.out.println(count +" row affected");


		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}





	}

}
