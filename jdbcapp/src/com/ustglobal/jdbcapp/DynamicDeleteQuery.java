package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DynamicDeleteQuery {

	public static void main(String[] args) {

		Connection conn= null;
		PreparedStatement pstmt = null;

		try {

			//Step 1 Load the Driver
			
			Class.forName("com.mysql.jdbc.Driver");

			//Step 2 get the Connection

			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);

			//step 3 Issue sql statement

			String sql="delete from employee_info where id=?";
			pstmt=conn.prepareStatement(sql);
			
			String eid=args[0];
			int id=Integer.parseInt(eid);
			pstmt.setInt(1, id);
			
			
			int count=pstmt.executeUpdate();

			//Step 4 read the result

			System.out.println(count +" row affected");


		}catch (SQLException e ) {
			e.printStackTrace();
		}catch (ClassNotFoundException ae) {
			ae.printStackTrace();
		}
		finally {
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
