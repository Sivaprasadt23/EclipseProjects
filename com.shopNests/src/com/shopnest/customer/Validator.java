package com.shopnest.customer;

import com.shopnest.dbHandler.DataFetcher;

public class Validator {
	public static boolean isValid(String uname,String passw) {
		String dbPass=DataFetcher.fetchPassword(uname);
		if(passw.equals(dbPass))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
