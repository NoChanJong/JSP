package com.lec.web.exception;

public class ServiceException2 extends RuntimeException {
	
	public ServiceException2(String message2) { super(message2); }
	public ServiceException2(String message2, Exception e) { super(message2, e); }
}
