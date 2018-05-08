package com.accenture.aa.banking.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ROLES")
public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6365505869188782057L;

	@Id
	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;
	
	public Role() {}
	
	public Role(String name) {
		this.name = name;
	}

	public String getName() {
		if(name != null) {
			return name.toUpperCase();
		}else {
			return null;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getAuthority() {
		return getName();
	}
}
