package com.cooksys.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.angular.entity.RoleEntity;
import com.cooksys.angular.entity.UserEntity;
import com.cooksys.angular.pojo.Unverified;
import com.cooksys.angular.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
	public boolean login(@PathVariable("username") String username, @PathVariable("password") String password) {
		return userService.isValidUser(username, password);
	}

	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public RoleEntity getRole(@RequestBody Unverified user) {
		return userService.isValidUser(user.getUsername(), user.getPassword()) ? userService.getRole(user.getUsername())
				: null;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public UserEntity getUser(@RequestBody Unverified user) {
		return userService.isValidUser(user.getUsername(), user.getPassword()) ? userService.getUser(user.getUsername())
				: null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserEntity getById(@PathVariable("id") long id)
	{
		return userService.getUser(id);
	}
}
