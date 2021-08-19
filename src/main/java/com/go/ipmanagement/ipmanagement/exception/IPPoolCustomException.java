package com.go.ipmanagement.ipmanagement.exception;

public class IPPoolCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IPPoolCustomException(String errorMessage){
		super(errorMessage);
	}

}
