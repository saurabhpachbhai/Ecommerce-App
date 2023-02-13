package com.userapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userapp.Service.UserService;
import com.userapp.entity.UserData;


@RestController
@RequestMapping("/ecommerce/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public UserData saveUser(@RequestBody UserData userData) {
		return userService.saveUser(userData);
	}
	@GetMapping("/allusers")
	public List<UserData> getAllUsers(){
		return userService.getAllUsers();
	}

}
