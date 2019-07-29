package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override 
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    
    @Override
    public List<String> findUsers(List<Long> idList) {
    	return this.userRepository.findUserIdList(idList);
    }
    
    @Override
    public List<User> findAllUsers() {
    	return this.userRepository.findAll();
    }
    
    
	
}
