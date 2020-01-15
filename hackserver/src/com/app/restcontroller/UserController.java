package com.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IuserDao;
import com.app.pojos.User;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private IuserDao dao;
	
	@PostMapping
	public ResponseEntity<?> insertUser(@RequestBody User user)
	{
		System.out.println(user);
		try {
			dao.addUser(user);
			return new ResponseEntity<String>("added successfully",HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> changePassword(@RequestBody User user)
	{
		System.out.println(user);
		try {
			dao.changePassword(user.getEmail(), user.getPasswd(),user.getNewPassword());
			return new ResponseEntity<String>("changed successfully",HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
