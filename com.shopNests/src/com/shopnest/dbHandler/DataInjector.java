package com.shopnest.dbHandler;

import java.sql.*;

public class DataInjector {
	public static String addCustomer(String uname,String mail,String passw,String gender,String address)
	{
		String driver="oracle.jdbc.driver.OracleDriver"; 
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="INSERT INTO customers VALUES(?,?,?,?,?)";
        String regStatus="";
        try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1,uname);
			pstm.setString(2,mail);
			pstm.setString(3,passw);
			pstm.setString(4,gender);
			pstm.setString(5,address);
			
			pstm.executeUpdate();
			
			regStatus="success";
			
		}
			catch(Exception e)
		{
				System.out.println("Problem in adding customer");
				e.printStackTrace();
				regStatus="fail";
		}
        finally
        {
        return regStatus;
        }
	}
	
	
	
	public static boolean addProduct(int pid,String pname,String pdesc,int pprice,String pimg)
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="INSERT INTO products VALUES(?,?,?,?,?)";
        try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, pid);
			pstm.setString(2, pname);
			pstm.setString(3, pdesc);
			pstm.setInt(4, pprice);
			pstm.setString(5, pimg);
			pstm.executeUpdate();
			
		}
			catch(Exception e)
		{
				System.out.println("Problem in adding product");
				e.printStackTrace();
        return false;
        }
        	return true;
        }

}
