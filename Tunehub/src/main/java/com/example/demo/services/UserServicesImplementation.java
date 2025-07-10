package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepositories;

@Service
public class UserServicesImplementation implements UsersServices{
	@Autowired
	UsersRepositories urepo;

	@Override
	public String addUsers(Users user) {
		urepo.save(user);
		return "user is created and saved";
	}

	@Override
	public boolean emailExists(String email) {
		if(urepo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validataUsers(String email, String password) {
		Users user=urepo.findByEmail(email);
		String dbPassword=user.getPassword();
		if(dbPassword.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		return (urepo.findByEmail(email).getRole());
		
	}

	@Override
	public Users getUsers(String email) {
		return urepo.findByEmail(email);
	}


}
