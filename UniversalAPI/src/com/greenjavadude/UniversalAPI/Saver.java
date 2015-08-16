package com.greenjavadude.UniversalAPI;

import java.io.*;

public class Saver {
	public boolean saveToSer(Object obj, String path){
		boolean success = false;
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			try{
				oos.writeObject(obj);
				oos.flush();
				success = true;
			}finally{
				oos.close();
			}
		}catch(Exception e){
			
		}
		return success;
	}
	
	public Object getFromSer(String path){
		Object obj = null;
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			try{
				obj = ois.readObject();
			}finally{
				ois.close();
			}
		}catch(Exception e){
			
		}
		return obj;
	}
	
	public static boolean saveStringToFile(String path, String string){
		boolean success = false;
		
		try{
			PrintWriter pw = new PrintWriter(path);
			try{
				pw.write(string);
				pw.flush();
				success = true;
			}finally{
				pw.close();
			}
		}catch(Exception e){
			
		}
		
		return success;
	}
	
	public static String getStringFromFile(String path){
	    String result = "";
	    BufferedReader br;
	    
	    try{
	    	br = new BufferedReader(new FileReader(path));
	    	String line;
	    	try{
	    		while((line = br.readLine()) != null){
	    			result += line + "\n";
	    		}
	    	}finally{
	    		br.close();
	    	}
	    }catch(Exception e){
	    	
	    }
	    
	    return result;
	}
}