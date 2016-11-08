package com.tangyu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SystemInterceptor()).excludePathPatterns("/reporting/cdrsRest","/login","/loginImage","/auth","/authPre","/error","/api/nbms/sync_numbers");
	}
}
