package com.deloitte.telecom.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
