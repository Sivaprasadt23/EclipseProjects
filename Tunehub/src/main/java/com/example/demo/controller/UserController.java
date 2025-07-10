package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServices;

@Controller
public class UserController {
	@Autowired
	UsersServices userv;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user)
	{
		boolean userstatus=userv.emailExists(user.getEmail());
		if(userstatus==false)
		{
			userv.addUsers(user);
			return "registerSuccess";
		}
		else
		{
			return "registerFail";
		}
	}
	@PostMapping("/login")
	public String validataUsers(@RequestParam String email,@RequestParam String password)
	{
		//invoking validateUsers() in service
		boolean loginstatus=userv.validataUsers(email,password);
		if(loginstatus==true)
		{
			//checking whether the user is customer or admin
			if(userv.getRole(email).equals("admin"))
			{
				return "adminHome";
			}
			else
			{
				return "customerHome";
			}		
		}
		else
		{
			return "loginFail";
		}
	}
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(String email)
	{
		Users user=userv.getUsers(email);
		 boolean userStatus=user.isPrime();
		 if(userStatus==true)
		 {
			 return "displaysongs";
		 }
		 else
		 {
			 return "payment";
		 }
	}
}
