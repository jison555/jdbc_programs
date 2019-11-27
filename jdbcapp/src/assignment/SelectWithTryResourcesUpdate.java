package assignment;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class SelectWithTryResourcesUpdate {
	
	public static void main(String[] args) {

		try(FileReader reader=new FileReader("Dbsecond.properties")) {

			Properties prop=new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driver-class-name"));
			String url=prop.getProperty("url");
			String sql=prop.getProperty("update-query");

			try(Connection conn=DriverManager.getConnection(url, prop);
					PreparedStatement pstmt=conn.prepareStatement(sql);) {
				
				String empid=args[0];
				int id=Integer.parseInt(empid);
				pstmt.setInt(4, id);
				
				String empname=args[1];
				pstmt.setString(1, empname);
				
				String empsal=args[2];
				int sal=Integer.parseInt(empsal);
				pstmt.setInt(2, sal);
				
				String empgender=args[3];
				pstmt.setString(3, empgender);
				
				int count=pstmt.executeUpdate();
				System.out.println(count +" rows affected");
			}




			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


}
