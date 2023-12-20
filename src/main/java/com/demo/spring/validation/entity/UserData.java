package com.demo.spring.validation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User_Data")
@Data
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "buildObj")
public class UserData {
	
	
	    @Id
	    @GeneratedValue
	    private int userId;
	    private String name;
	    private String email;
	    private String mobile;
	    private String gender;
	    private int age;
	    private String nationality;
	

}
