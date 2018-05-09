package com.accenture.aa.banking.configs;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.accenture.aa.banking.services.UsersService;

@Service("userDetailsService")
public class AppUserDetailsService implements UserDetailsService {

	private final UsersService usersService;

	public AppUserDetailsService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Authenticating user " + username + " using credentials from the database.");
		UserDetails user = usersService.getUserCredentials(username);
		if(user !=null) {
			return user;
		}else {
			throw new UsernameNotFoundException("No user found with username : "+username);
		}
	}
}
