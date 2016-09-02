package com.vinay.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.dao.UserRepository;
import com.vinay.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {

		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setIsDeleted(new Integer(0));

		user = userRepository.save(user);

		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

}
