package com.cooksys.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RoleEntity")
public class RoleEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "RoleName")
	private String roleName;

	public RoleEntity() {
	}

	public RoleEntity(String roleName) {
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
