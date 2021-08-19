package com.go.ipmanagement.ipmanagement.exception;

public class IPPoolNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IPPoolNotFoundException(String errorMessage){
		super(errorMessage);
	}

}
