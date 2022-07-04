package com.asm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.asm.intercepter.AdminIntercepter;

@Configuration
public class AdminConfig implements WebMvcConfigurer{
	
	@Autowired
	private AdminIntercepter admin;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(admin).addPathPatterns("/admin/**");
	}

}
