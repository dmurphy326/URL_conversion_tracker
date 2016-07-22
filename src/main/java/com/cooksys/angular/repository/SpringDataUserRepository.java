package com.cooksys.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.angular.entity.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByUsername(String username);
	
	public UserEntity findById(long id);

}
