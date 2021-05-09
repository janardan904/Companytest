package com.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/rest/users")
public class UserController {
	@Autowired
	private UserService userservice;
	@RequestMapping(method=RequestMethod.GET,value="all",produces="application/json")
	private List<User> getAllUsers() {  
		return userservice.getAllUsers();  
	}  
	@RequestMapping(method=RequestMethod.GET,value="/user/{userId}",produces="application/json")
	private User getUser(@PathVariable("userId") int userId)  { 
	return userservice.getUserById(userId);  
	}  
	@DeleteMapping("/delete")  
	private void deleteUser(@PathVariable("userId") int userId)   {
		userservice.delete(userId);  
	}  
	@PostMapping(value="/save", produces= "application/json" ,
			                    consumes = "application/json" )
	private int saveUsers(@RequestBody User user)  { 
		userservice.saveOrUpdate(user);  
	return user.getUserId();  
	}  
	@PutMapping("/update")  
	private User update(@RequestBody User user)   {
		userservice.saveOrUpdate(user);  
	return user;  
	}  
}