package com.seleniumexpress.seapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seleniumexpress.seapp.dto.RegistrationDTO;

@Controller
public class RegistrationController {
	
	
	
	JdbcUserDetailsManager jdbcUserDetailsManager;
	
	PasswordEncoder passwordEncoder;
	
	@Lazy
	public RegistrationController(JdbcUserDetailsManager jdbcUserDetailsManager,PasswordEncoder passwordEncoder) {
		
	   this.jdbcUserDetailsManager = jdbcUserDetailsManager;
	   this.passwordEncoder = passwordEncoder;
	}
	

	@GetMapping("/register")
	public String showRegistrationPage(@ModelAttribute("reg") RegistrationDTO registrationDTO) {
		
		
		
		

		return "register";
	}

	// /process-registration?user=digna&pass=digna
	@ResponseBody
	@PostMapping("/process-registration")
	public String processRegistrationPage(RegistrationDTO registrationDTO) {

		
		String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());
		
		UserDetails appUser = User
				.withUsername(registrationDTO.getUsername())
				.password(encodedPassword)
				.roles("user")
				.build();
		
		jdbcUserDetailsManager.createUser(appUser);
		
		
		return "registration sucessful for the user " + registrationDTO.getUsername();
	}

}
