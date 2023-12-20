package com.demo.spring.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.validation.entity.UserData;
@Repository
public interface UserRepository extends JpaRepository<UserData, Integer>{
	
	UserData findByUserId(int id);

}
