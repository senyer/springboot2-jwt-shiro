package com.zygk.common.exception;

public class NotImplementException extends RuntimeException {
	
	private static final long serialVersionUID = -45094236609126082L;

	public NotImplementException() {
		super("method not implements");
	}
}
