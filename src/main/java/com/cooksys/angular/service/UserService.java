package com.cooksys.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.angular.entity.RoleEntity;
import com.cooksys.angular.entity.UserEntity;
import com.cooksys.angular.repository.SpringDataUserRepository;

@Service
public class UserService {

	@Autowired
	SpringDataUserRepository repo;

	public boolean isValidUser(String username, String password) {
		UserEntity user = repo.findByUsername(username);
		if (user == null) {
			return false;
		} else {
			return (user.getUsername().equals(username) && user.getPassword().equals(password)) ? true : false;
		}
	}

	public RoleEntity getRole(String username) {
		UserEntity user = repo.findByUsername(username);
		return user != null ? user.getRoleEntity() : null;
	}

	public UserEntity getUser(String username) {
		return repo.findByUsername(username) != null ? repo.findByUsername(username) : null;

	}

	public UserEntity getUser(long id) {
		return repo.findById(id) != null ? repo.findById(id) : null;
	}

}
