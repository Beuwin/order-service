package com.demo.spring.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.validation.dto.UserDTO;
import com.demo.spring.validation.entity.UserData;
import com.demo.spring.validation.exception.UserDataNotFoundException;
import com.demo.spring.validation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public UserData saveUser(UserDTO userRequest) {
		UserData user = UserData.
				buildObj(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return userRepo.save(user);
    } 
	
	 public List<UserData> getALlUsers() {
	        return userRepo.findAll();
	    }
	 
	 public UserData getUser(int userId) throws UserDataNotFoundException {
		 UserData data = userRepo.findByUserId(userId);
		 if(data!=null) {
			 
			 return userRepo.findByUserId(userId);
		 }else {
			 
			 throw new UserDataNotFoundException("The given Id do not have any User Object :" +userId);
		 }
		
	 }


}
