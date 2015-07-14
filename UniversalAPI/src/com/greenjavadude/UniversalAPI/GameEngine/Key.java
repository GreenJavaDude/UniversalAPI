package com.greenjavadude.UniversalAPI.GameEngine;

public class Key {
	private boolean pressed;
	
	public Key(){
		pressed = false;
	}
	
	public void setPressed(boolean b){
		pressed = b;
	}
	
	public boolean getPressed(){
		return pressed;
	}
}