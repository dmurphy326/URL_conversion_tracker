package com.cooksys.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserEntity")
public class UserEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "Username")
	private String username;

	@Column(name = "Password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "RoleEntity")
	private RoleEntity roleEntity;

	public UserEntity() {
	}

	public UserEntity(String username, String password, RoleEntity roleEntity) {
		this.username = username;
		this.password = password;
		this.roleEntity = roleEntity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

}
