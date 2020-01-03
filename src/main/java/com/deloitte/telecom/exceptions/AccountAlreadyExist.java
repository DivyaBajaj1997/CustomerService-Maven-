package com.deloitte.telecom.exceptions;

public class AccountAlreadyExist extends RuntimeException {
	public AccountAlreadyExist(String msg) {
		super(msg);
	}

}
