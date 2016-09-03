package com.vinay.service;

import java.util.List;

import com.vinay.models.User;

public interface UserService {

	public User save(User user);

	public List<User> findAll();

	public User findOne(Long userId);

	public User update(User user);

}
