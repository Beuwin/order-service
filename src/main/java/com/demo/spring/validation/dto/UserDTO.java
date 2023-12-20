package com.demo.spring.validation.dto;

import com.demo.spring.validation.entity.UserData;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	  	private int userId;
	  	@NotNull(message="username shouldn't be null")
	    private String name;
	  	@Email(message="Invalid email Address")
	    private String email;
	  	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
	    private String mobile;
	    private String gender;
	    @Min(18)
	    @Max(60)
	    private int age;
	    private String nationality;

}
