package com.tangyu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tangyu.model.MyUserDetails;
import com.tangyu.model.User;
import com.tangyu.model.UserRole;
import com.tangyu.service.UserRoleService;
import com.tangyu.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user;
		try {
			System.out.println(3333);
			user = userService.queryByEmail(email);
		} catch (Exception e) {
			throw new UsernameNotFoundException("user select fail");
		}
		if (user == null) {
			throw new UsernameNotFoundException("no user found");
		} else {
			try {
				List<UserRole> roles = userRoleService.queryByUserId(user.getId());
				return new MyUserDetails(user, roles);
			} catch (Exception e) {
				throw new UsernameNotFoundException("user role select fail");
			}
		}
	}
}
