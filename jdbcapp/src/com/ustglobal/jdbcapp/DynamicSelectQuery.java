package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql= "select * from employee_info where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			conn=DriverManager.getConnection(url);
			
			pstmt=conn.prepareStatement(sql);
			
			String empid=args[0];
			int id=Integer.parseInt(empid);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int eid=rs.getInt("id");
				String ename=rs.getString("name");
				int esal=rs.getInt("sal");
				String egender=rs.getString("gender");
				
				System.out.println("id is "+eid);
				System.out.println("name is "+ename);
				System.out.println("sal is "+esal);
				System.out.println("gender is "+egender);
				
			}		
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			//Step 5 Close the JDBC Objects
			
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
		
	}//end of main
}
