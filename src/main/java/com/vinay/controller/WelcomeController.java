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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/user/{username}")
	public String saveUser(@PathVariable String username, Map<String, List<User>> map) {

		User user = new User();
		user.setUserName(username);

		user = userService.save(user);

		// map.put("userId", Long.toString(user.getUserId()));
		// map.put("userName", user.getUserName());
		// map.put("created", user.getCreated().toString());
		// map.put("lastUpdated", user.getUpdated().toString());

		// String status = null;
		//
		// if (user.getIsDeleted() == 0) {
		// status = "Active";
		// } else {
		// status = "Inactive";
		// }
		//
		// map.put("status", status);

		List<User> userList = new ArrayList<User>();
		userList.add(user);

		map.put("userList", userList);

		return "user";
	}

	@RequestMapping("/user/getAll")
	public String getAll(Map<String, List<User>> map) {

		map.put("userList", userService.findAll());

		return "user";
	}

	@RequestMapping("/user/getUser/{userId}")
	public String getUser(@PathVariable Long userId, Map<String, List<User>> map) {

		List<User> userList = new ArrayList<User>();
		userList.add(userService.findOne(userId));

		map.put("userList", userList);

		return "user";
	}

}