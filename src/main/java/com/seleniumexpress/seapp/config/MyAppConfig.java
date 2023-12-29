package com.seleniumexpress.seapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com")
public class MyAppConfig {
	
	@Bean
	InternalResourceViewResolver viewResolver() {
		
		
		return new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
	}

}
