package com.example.sso.Exception;

public class UserCreationException extends CustumException {

	public UserCreationException(String errorCode, String message) {
		super(errorCode, message);
	}

	public UserCreationException(String errorCode, Throwable throwable) {
		super(errorCode, throwable);
	}

	public UserCreationException(String errorCode, String message, Throwable throwable) {
		super(errorCode, message, throwable);
	}

	public UserCreationException(UserCreationException e) {
		super(e);
	}
}
