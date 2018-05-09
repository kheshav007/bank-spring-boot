package com.accenture.aa.banking.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.accenture.aa.banking.dao.entities.Role;
import com.accenture.aa.banking.dao.entities.User;
import com.accenture.aa.banking.dao.repositories.RoleRepository;
import com.accenture.aa.banking.dao.repositories.UserRepository;

@Service
@Transactional
public class UsersService {

	private static final String[] ROLES_LIST = new String[] { "ROLE_CREATE_EMPLOYEE" };

	private final UserRepository userRepository;

	private final RoleRepository roleRepository;
	
	private final BCryptPasswordEncoder passwordEncoder;

	public UsersService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public UserDetails getUserCredentials(String username) {
		User user = userRepository.findOne(username);
		return (user != null)? new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRoles()) : null;
	}

	/**
	 * here we insert all the roles in the database,
	 * and we create the primary user with all the roles given to him.
	 */
	@PostConstruct
	public void initUserAndRoles() {
		for (String role : ROLES_LIST) {
			roleRepository.save(new Role(role));
		}
		
		User cyrano = new User("cyrano", passwordEncoder.encode("cyrano"), "Cyrano","DJIKE");
		Set<Role> roles = new HashSet<>();
		for (String role : ROLES_LIST) {
			roles.add(roleRepository.findOne(role));
		}
		cyrano.setRoles(roles);
		userRepository.save(cyrano);
	}

}
