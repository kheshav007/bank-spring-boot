package com.accenture.aa.banking.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role {

	@Id
	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

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
}
