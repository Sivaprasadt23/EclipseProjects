package com.shopnest.dbHandler;

import java.sql.*;
import java.util.*;

import com.shopnest.product.Product;

public class DataFetcher {
	private static String pimg;



	public static String fetchPassword(String uname)
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="SELECT pass FROM customers WHERE uname=?";
		String dbPass="";
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			rs.next();
			dbPass=rs.getString(1);
		} catch (Exception e) {
			System.out.println("Login issues");
			e.printStackTrace();
		}
		return dbPass;
		
	}
	
	
	
	public static  List fetchUsersInfo()
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="SELECT uname,mail,gender,address FROM customers";
		List ulist=new ArrayList();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
				ulist.add(temp);
			}
		}
			catch(Exception e)
		{
				System.out.println("Problem in login");
		}
		return ulist;
	}
	
	
	
	public static List fetchProductsInfo()
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="SELECT pid,pname,pdesc,pprice,pimg FROM products";
		List ilist=new ArrayList();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				String temp=rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5);
				ilist.add(temp);
			}
		}
			catch(Exception e)
		{
				System.out.println("Problem in fetching product");
				e.printStackTrace();
		}
		return ilist;
	}
	
	
	
	public static Product getProductById(int pid)
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="SELECT pname,pprice,pimg FROM products WHERE pid=?";
                      Product p=null;
                      try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, pid);
			ResultSet rs=pstm.executeQuery();
			rs.next();
			String pname=rs.getString(1);
			int pprice=rs.getInt(2);
			p=new Product(pid,pname,pprice,pimg);
			
		}
			catch(Exception e)
		{
				System.out.println("Problem in fetching product by id");
				e.printStackTrace();
		}
                      finally
                      {
                    	  return p;
                      }
	}

}
