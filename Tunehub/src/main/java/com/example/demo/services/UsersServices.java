package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UsersServices {
	public String addUsers(Users user);
	public boolean emailExists(String email);
	public boolean validataUsers(String email,String password);
	public String getRole(String email);
	public Users getUsers(String email);
	

}
