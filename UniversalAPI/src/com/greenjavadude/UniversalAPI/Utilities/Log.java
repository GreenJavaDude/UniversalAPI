package com.greenjavadude.UniversalAPI.Utilities;

import javax.swing.JTextArea;

public class Log {
	private static final int LOGGER = -1;
	
	public static final int INFO = 0;
	public static final int ERROR = 1;
	
	private JTextArea display;
	private boolean console;
	
	public Log(){
		display = null;
		console = false;
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				log("Log stopped", LOGGER);
			}
		});
	}
	
	public Log(JTextArea textarea){
		this();
		display = textarea;
		
		log("Log started", LOGGER);
	}
	
	public Log(boolean consoleLogging){
		this();
		console = consoleLogging;
		
		log("Log started", LOGGER);
	}
	
	public Log(JTextArea textarea, boolean consoleLogging){
		this();
		display = textarea;
		console = consoleLogging;
		
		log("Log started", LOGGER);
	}
	
	public void log(String message, int type){
		switch(type){
		case INFO:
			display("INFO: " + message + "\n");
			break;
		case ERROR:
			display("ERROR: " + message + "\n");
			break;
		case LOGGER:
			display("LOG: " + message + "\n");
			break;
		}
	}
	
	private void display(String text){
		if(console){
			System.out.print(text);
		}
		if(display != null){
			display.append(text);
		}
	}	
}