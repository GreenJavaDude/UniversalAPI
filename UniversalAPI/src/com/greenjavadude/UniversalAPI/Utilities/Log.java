package com.greenjavadude.UniversalAPI.Utilities;

import java.io.PrintWriter;
import javax.swing.JTextArea;

public enum Log {
	INSTANCE;
	
	private JTextArea display;
	private boolean console;
	private PrintWriter writer;
	
	private boolean debugmode;
	
	/**Sets Log up, is necessary to use Log
	 * 
	 * @param enableConsole enables/disables non-debug messages
	 * @param debug enables/disables debug messages
	 * @param area JTextArea to display log, set null to disable
	 * @param path path to write log to
	 */
	public void setup(boolean enableConsole, boolean debug, JTextArea area, String path){
		display = area;
		console = enableConsole;
		debugmode = debug;
		
		if(path != null){
			try{
				writer = new PrintWriter(path);
			}catch(Exception e){
				writer = null;
				logger("Failed to initialize writer");
			}
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				logger("Log stopped");
				if(writer != null){
					writer.flush();
					writer.close();
				}
			}
		});
		
		logger("Log started");
	}
	
	/**Logs info message
	 * 
	 * @param message The message that will be logged
	 */
	public void log(String message){
		display("INFO: " + message + "\n");
	}
	
	/**Logs a debug message, can be disabled in setup
	 * 
	 * @param message The debug-message that will be logged
	 */
	public void debug(String message){
		if(debugmode){
			display("DEBUG: " + message + "\n");
		}
	}
	
	/**Logs an error message
	 * 
	 * @param message The error-message that will be logged
	 */
	public void error(String message){
		display("ERROR: " + message + "\n");
	}
	
	private void logger(String message){
		display("LOG: " + message + "\n");
	}
	
	private void display(String text){
		if(console){
			System.out.print(text);
		}
		if(display != null){
			display.append(text);
		}
		if(writer != null){
			writer.write(text);
		}
	}
}