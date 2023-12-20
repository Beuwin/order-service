package com.demo.spring.validation.advise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.spring.validation.exception.UserDataNotFoundException;

@RestControllerAdvice
public class UserAdvise {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException argumentNotValidException){
		Map<String,String> hm = new HashMap<String, String>();
		argumentNotValidException.getBindingResult().getFieldErrors().forEach(
				errorData -> hm.put(errorData.getField(), errorData.getDefaultMessage())
				);
		return hm;
	}
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserDataNotFoundException.class)
	public Map<String,String> handleBusinessUserException(UserDataNotFoundException usrDataExc){
		Map<String,String> usrMsgMap = new HashMap<String, String>();
		usrMsgMap.put("errorMsg", usrDataExc.getMessage());
		return usrMsgMap;
	}

}
