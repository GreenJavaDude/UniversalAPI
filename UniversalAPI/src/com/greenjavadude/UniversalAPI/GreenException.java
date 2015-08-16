package com.greenjavadude.UniversalAPI;

public class GreenException extends Exception{
	private static final long serialVersionUID = -2357425457278006252L;
	
	public GreenException(String error){
		super(error);
	}
	
	public GreenException(String error, Throwable cause){
		super(error, cause);
	}
}