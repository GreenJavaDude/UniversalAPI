package com.greenjavadude.UniversalAPI.GameEngine;

import java.io.File;

public class Test{
	public static void main(String[] args){
		Sound sound = new Sound(new File("C://Programming//test.wav"), Sound.SINGLE);
		sound.play();
		
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			
		}
		
		sound.pause();
		
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			
		}
		
		sound.play();
		
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			
		}
		
		sound.skipTo(sound.getTotalDuration() - 10);
	}
}