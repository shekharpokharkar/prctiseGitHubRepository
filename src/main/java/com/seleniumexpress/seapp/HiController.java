package com.seleniumexpress.seapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	
	@GetMapping("/hi")
	public String sayHi() {
		
		return "Hi everyone !";
	}
	
	@GetMapping("/hello")
    public String sayHello() {
		
		return "Hello everyone !";
	}
	
	
	@PostMapping("/add-data")
	public String addData() {
		
		//db insertion
		return "data added";
	}

}
