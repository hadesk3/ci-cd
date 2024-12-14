package com.tutorial.employeemanagmentbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class home {
	@GetMapping
	public String homepage()
	{
		return "check ci/cd";
	}
}
