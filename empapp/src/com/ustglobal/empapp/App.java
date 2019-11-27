package com.ustglobal.empapp;

import java.util.List;
import java.util.Scanner;

import com.ustglobal.empapp.dao.EmployeeDAO;
import com.ustglobal.empapp.dao.EmployeeDAOImpl;
import com.ustglobal.empapp.dto.EmployeeBean;
import com.ustglobal.empapp.util.EmployeeFactory;

public class App {

	public static void main(String[] args) {

		System.out.println("press 1 to get all data");
		System.out.println("press 2 to insert the data");
		System.out.println("press 3  to update the data");
		System.out.println("press 4  to delete the data");
		System.out.println("press 5 to search single employee");


		Scanner scn = new Scanner(System.in);
		int ch = scn.nextInt();

		switch(ch) {

		case 1:
			EmployeeDAO dao = EmployeeFactory.getEmployeeDAO();
			List<EmployeeBean> result=  dao.getAllEmployeeData();

			for(EmployeeBean bean : result) {
				System.out.println("id is "+bean.getId()); 
				System.out.println("name is "+bean.getName()); 
				System.out.println("sal is "+bean.getSal()); 
				System.out.println("gender is "+bean.getGender()); 
				System.out.println("=====================================");
			}
			break;
		case 2:
			EmployeeDAO dao2 = EmployeeFactory.getEmployeeDAO();
			EmployeeBean bean = new EmployeeBean();
//			System.out.println("enter id :" );
//			int id = scn.nextInt();
//			System.out.println("enter name:");
//			String name = scn.next();
//			System.out.println("enter salary:");
//			int sal = scn.nextInt();
//			System.out.println("enter gender:");
//			String gender = scn.next();
			bean.setId(22);
			bean.setName("fakru");
			bean.setSal(34000);
			bean.setGender("m");
			
			int countinsert = dao2.insertEmployeeData(bean);
			System.out.println(countinsert +" is inserted");	
			break;

		case 3:
			EmployeeDAO dao3 = EmployeeFactory.getEmployeeDAO();
			
			EmployeeBean bean2 = new EmployeeBean();
			bean2.setId(20);
			bean2.setName("Abhi");
			bean2.setSal(20000);
			bean2.setGender("m");
			
			int countupdate = dao3.updateEmployeeData(bean2);
			System.out.println(countupdate +" is updated");
			
			break;

		case 4:	
			EmployeeDAO dao4 = EmployeeFactory.getEmployeeDAO();
			int countdelete = dao4.deleteEmployeeData(8);
			System.out.println(countdelete +" is deleted");
			break;
		case 5:
			EmployeeDAO dao5 =EmployeeFactory.getEmployeeDAO();
			System.out.println("enter the searching id");
			int id1=scn.nextInt();
			EmployeeBean bean1 = dao5.searchEmployeeData(id1);
			if(bean1 !=null) {
				System.out.println("id is "+bean1.getId()); 
				System.out.println("name is "+bean1.getName()); 
				System.out.println("sal is "+bean1.getSal()); 
				System.out.println("gender is "+bean1.getGender()); 
			}
			else {
				System.out.println("no data found");
			}
			break;
		}
	}
}