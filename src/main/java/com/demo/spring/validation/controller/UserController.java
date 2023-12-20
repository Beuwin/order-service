package com.demo.spring.validation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.validation.dto.UserDTO;
import com.demo.spring.validation.entity.UserData;
import com.demo.spring.validation.exception.UserDataNotFoundException;
import com.demo.spring.validation.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserData> saveUser(@RequestBody @Valid UserDTO userdto){
		
		return new ResponseEntity<>(userService.saveUser(userdto),HttpStatus.CREATED);
	}
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserData>> getAllUsers(){
		
		return ResponseEntity.ok(userService.getALlUsers());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserData> getUser(@PathVariable int id) throws UserDataNotFoundException{
		
		return ResponseEntity.ok(userService.getUser(id));
	}
}
