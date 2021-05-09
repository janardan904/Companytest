package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	// fetch the record from db
	public List<User> getAllUsers()   
	{  
	List<User> users= new ArrayList<User>();  
	repository.findAll().forEach(user1->users.add(user1));
	return users;
	}  
	 //get the perticular record
	public User getUserById(int userId)   
	{  
	return repository.findById(userId).get();  
	}  
	
	//save or update the record
	public void saveOrUpdate(User user)   
	{  
	   repository.save(user);  
	}  

	//delete the record
	public void delete(int userId)   
	{  
	repository.deleteById(userId);  
	}  
	//update the record
	public void update(User user, int userId)   
	{  
	repository.save(user);  
	}  
}
