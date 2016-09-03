/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vinay.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vinay.models.User;
import com.vinay.service.UserService;

@Controller
public class WelcomeController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		return "welcome";
	}

	@RequestMapping("/user/getUser/{userId}")
	public String getUser(@PathVariable Long userId, Map<String, User> map) {

		map.put("user", userService.findOne(userId));

		return "user";
	}


	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String saveNewEntry(HttpServletRequest request, Map<String, List<User>> map) {

		String username = request.getParameter("username");

		User user = new User();
		user.setUserName(username);

		user = userService.save(user);

		map.put("userList", userService.findAll());

		return "home";
	}
	
	@RequestMapping("/home")
	public String doAll(Map<String, List<User>> map)
	{
		map.put("userList", userService.findAll());
		return "home";
	}
	
	@RequestMapping("/edit/{userId}")
	public String updateUser(@PathVariable Long userId,HttpServletRequest request,Map<String, List<User>> map) {
		
		User user = userService.findOne(userId);
		
		String userName = request.getParameter("userName");
		
		user.setUserName(userName);
		
		userService.update(user);
		
		map.put("userList", userService.findAll());
		
		return "home";
	}

}