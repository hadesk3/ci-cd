package com.tutorial.employeemanagmentbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class home {
	public String homepage()
	{
		return "hello";
	}
}
