package com.auto.dealeraudit.exception;

public class CustomException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMesaage;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.errorMesaage;
	}

	public CustomException() {
		super();
	}

	public CustomException(String errorMesaage) {
		super();
		this.errorMesaage = errorMesaage;
	}
}
