package com.tutorial.employeemanagmentbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.employeemanagmentbackend.dto.LoginRequest;
import com.tutorial.employeemanagmentbackend.dto.Response;
import com.tutorial.employeemanagmentbackend.model.User;
import com.tutorial.employeemanagmentbackend.service.UserService;

@RestController
@RequestMapping("/auth")
public class authController {
	
	@Autowired
	UserService userService;
	@PostMapping("/registry")
	public ResponseEntity<Response> registry(@RequestBody User user)
	{
		Response response = userService.register(user);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest)
	{
		Response response = userService.login(loginRequest);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
}
