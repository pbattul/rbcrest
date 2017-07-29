package com.RBC.Controler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.RBC.model.CustomErr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	/*@Autowired
	CustomErr customErr;*/
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e){
		//customErr = new CustomErr(e.getMessage());
		System.out.println("Inside Exception Hadler...");
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
