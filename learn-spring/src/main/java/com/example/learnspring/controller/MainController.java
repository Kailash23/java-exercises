package com.example.learnspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnspring.service.PrintService;


@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private PrintService service;
	
	@GetMapping()
	public void callService() {
		service.print();
	}
	
}
