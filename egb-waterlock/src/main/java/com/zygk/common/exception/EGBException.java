package com.zygk.common.exception;

public class EGBException extends RuntimeException{
	
	private static final long serialVersionUID = -5477333596181391581L;

	public EGBException (String errorMessage) {
		super(errorMessage);
	}
	
	public EGBException(String errorMessage, Exception e) {
	    super(errorMessage, e);
	}
}
