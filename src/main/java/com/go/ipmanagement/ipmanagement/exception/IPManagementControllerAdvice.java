package com.go.ipmanagement.ipmanagement.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class IPManagementControllerAdvice extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<Object> handleNoSuchElementException(Exception ex, WebRequest request) {
		ExceptionResponse res = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IPPoolCustomException.class)
	public final ResponseEntity<Object> handleIPPoolCustomException(Exception ex, WebRequest request) {
		ExceptionResponse res = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
	}
}
