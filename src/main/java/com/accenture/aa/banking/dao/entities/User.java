package com.accenture.aa.banking.dao.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class User {

	@Id
	@Column(name = "USERNAME", nullable = false, length = 60)
	private String username;

	@Column(name = "PASSWORD", nullable = false, length = 100)
	private String password;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@ManyToMany
	@JoinTable(
			name = "USERS_ROLES",
			joinColumns = { @JoinColumn(name = "USER_USERNAME", referencedColumnName="USERNAME")}, 
			inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName="NAME") })
	private Set<Role> roles;
	
	public User() {
	}

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoles() {
		return  roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
