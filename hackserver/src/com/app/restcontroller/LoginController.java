package com.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IuserDao;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private IuserDao dao;

	@PostMapping
	public ResponseEntity<?> validateUser(@RequestBody User login)
	{
		System.out.println(login.getEmail() +"  "+login.getPasswd());
		try {
			    User user = dao.validateUser(login.getEmail(), login.getPasswd());
			    System.out.println(user);
			   return new ResponseEntity<User>(user,HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping
	
	{
		System.out.println(login.getEmail() +"  "+login.getPasswd());
		try {
			    User user = dao.validateUser(login.getEmail(), login.getPasswd());
			    System.out.println(user);
			   return new ResponseEntity<User>(user,HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
