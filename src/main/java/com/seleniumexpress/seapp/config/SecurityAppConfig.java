package com.seleniumexpress.seapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.*;

import javax.sql.DataSource;

import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {
	
	
	@Autowired
	HttpSecurity httpSecurity;
	

	
//	@Bean
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		
//
//		UserDetails akhilUser = 
//				User
//				.withUsername("akhil")
//				.password("$2a$10$v972TZfOUWpnXvPXIbtoy.UGReYFLmX5l0S7hiyluqP5MxcVYugze")
//				.roles("admin","user")
//				.build();
//		
//		UserDetails anilUser = User
//				.withUsername("anil")
//				.password("$2a$10$VP/4g/fKUnzrmW5Mixf4Q./GOSUYTJTdztqUBeC9B2jubsxxGg18y")
//				.roles("user")
//				.build();
//
//		
//		return new InMemoryUserDetailsManager(akhilUser,anilUser);
//		
//		
//	}
	
	
	@Bean
	SecurityFilterChain settingUpHttpSecurity() throws Exception{
		
		//httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
		
		httpSecurity.authorizeHttpRequests(customizer -> {
			
			customizer
			.requestMatchers("/hi","/register","/WEB-INF/view/**","/process-registration").permitAll()
			.anyRequest().authenticated();
			
		});
		
		httpSecurity.formLogin();
		
		httpSecurity.httpBasic();
		
		httpSecurity.csrf().disable();
		

		
		return httpSecurity.build();
	}
	
	
	
	
	@Bean
	public DataSource datasource() {
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("abhilash");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/se-morning");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return driverManagerDataSource;
	}
	
	
	
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		
		
		return new JdbcUserDetailsManager(datasource());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	@Bean
	HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
		
		return new HandlerMappingIntrospector();
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		
		
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Bean
//	public InMemoryUserDetailsManager setUpUser(){
//	
//	ArrayList<GrantedAuthority> authoritiesList = new ArrayList<>();
//	
//	authoritiesList.add(new SimpleGrantedAuthority("admin"));
//	authoritiesList.add(new SimpleGrantedAuthority("user"));
//
//	
//	UserDetails abhilashUser = new User("abhilash", "abhilash", authoritiesList);
//	
//	
//	InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//	inMemoryUserDetailsManager.createUser(abhilashUser);
//	//inMemoryUserDetailsManager.createUser(sudhaUser);
//
//	
//	return inMemoryUserDetailsManager;
//	
//	
//	
//	}
//	
//	
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		
//		
//		return NoOpPasswordEncoder.getInstance();
//		
//	}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
