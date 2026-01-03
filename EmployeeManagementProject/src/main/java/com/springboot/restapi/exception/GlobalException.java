package com.springboot.restapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(RuntimeException.class)
	 public Map<String, String> handleException(RuntimeException ex){
		 
		 Map<String, String> error = new HashMap<String, String>();
		 
		 error.put("error", ex.getMessage());
		 
		 return error; 
	 }
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
		 Map<String, String> error = new HashMap<String, String>();
		 ex.getBindingResult().getFieldError().getDefaultMessage();
		 
		 return error;				
		 
	 }
}
