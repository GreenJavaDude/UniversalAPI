package com.greenjavadude.Utilities;

import java.io.*;

public class Saver{
	public boolean saveToSer(Object obj, String path){
		boolean success = false;
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			try{
				oos.writeObject(obj);
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
	
	public static boolean saveStringToTXT(String path, String string) {
		BufferedWriter bw = null;
		boolean success = false;
		try{
			bw = new BufferedWriter(new FileWriter(path));
			try{
				bw.write(string);
				success = true;
			}finally{
				bw.close();
			}
		}catch(Exception e){
			
		}
		return success;
	}
	
	public static String getStringFromFile(String fileName) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String result=null;
		try{
			br = new BufferedReader(new FileReader(fileName));
			try{
				String s;
				while((s = br.readLine()) != null){
					//add enter because removed by readline()
					sb.append(s);
					sb.append("\n");
				}
			}finally{
				br.close();
			}
		}catch(Exception e){
			
		}
		result = sb.toString();
		return result;
	}
}