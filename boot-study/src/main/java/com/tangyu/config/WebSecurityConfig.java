package com.tangyu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.tangyu.utils.MyAuthenticationProvider;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationProvider provider;// 自定义验证
	@Autowired
	private UserDetailsService userDetailsService;// 自定义用户服务


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/", "/assets/**", "/auth", "/getCode").permitAll()// 无需访问权限
				// .antMatchers(StaticParams.PATHREGX.AUTHADMIN).hasAuthority(StaticParams.USERROLE.ROLE_ADMIN)//
				// admin角色访问权限
				// .antMatchers(StaticParams.PATHREGX.AUTHUSER).hasAuthority(StaticParams.USERROLE.ROLE_USER)//
				// user角色访问权限
				.anyRequest()// all others request authentication
				.authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(222);
		// 将验证过程交给自定义验证工具
		auth.authenticationProvider(provider);
	}
}
