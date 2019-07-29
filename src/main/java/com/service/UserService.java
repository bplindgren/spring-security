package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	User save(User user);
	
	User findByUsername(String username);
	
	List<String> findUsers(List<Long> idList);
	
	List<User> findAllUsers();
}
