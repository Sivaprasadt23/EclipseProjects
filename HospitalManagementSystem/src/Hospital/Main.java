package Hospital;

import java.util.*;

import Model.Database;
import View.Login;

public class Main {
	
	public static void main(String[] args) {
		 new Login(new Scanner(System.in), new Database()); 
		/*
		 * System.out.println("Welcome to the Hospital Management.");
		 * System.out.println("1. Login\n2. Register");
		 * 
		 * Database db=new Database(); Scanner scan=new Scanner(System.in); int
		 * choice=scan.nextInt(); if(choice==1) { new Login(scan,db); } else
		 * if(choice==2) { new Register(scan,db); } else {
		 * System.out.println("Invalid Choice"); }
		 */
	}

}
