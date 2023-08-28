package com.example.sso.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthControllerAdvice extends ResponseEntityExceptionHandler {

//	public final ResponseEntity<ErrorResponseDto>(UserCreationException uce)
//	{
//		return new ResponseEntity<ErrorResponseDto>(uce.getErrorCode(), uce.getMessage());
//	}

}
