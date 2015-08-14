package com.greenjavadude.UniversalAPI.Utilities;

import java.io.PrintWriter;

import javax.swing.JTextArea;

public class Log {
	private static final int LOGGER = -1;
	public static final int INFO = 0;
	public static final int ERROR = 1;
	
	private JTextArea display;
	private boolean console;
	private PrintWriter writer;
	
	private boolean debugmode;
	
	/**Creates a new Log
	 * 
	 * @param enableConsole enables/disables console output
	 * @param pathToSave path to log file, if you don't want a log file, say null
	 * @param display JTextArea to which will be used as a log, if you don't want that, say null
	 * @param debug enables/disables debug information
	 */
	public Log(boolean enableConsole, String pathToSave, JTextArea display, boolean debug){
		this.display = display;
		console = enableConsole;
		debugmode = debug;
		if(pathToSave != null){
			try{
				writer = new PrintWriter(pathToSave);
			}catch(Exception e){
				writer = null;
				log("Failed to initialize writer", LOGGER);
			}
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				log("Log stopped", LOGGER);
				if(writer != null){
					writer.flush();
					writer.close();
				}
			}
		});
		
		log("Log started", LOGGER);
	}
	
	/**Logs a message
	 * 
	 * @param message the message that will be logged
	 * @param type use for example Log.INFO to log info messages
	 */
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
	
	public void debug(String message){
		if(debugmode){
			display("DEBUG: " + message + "\n");
		}
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