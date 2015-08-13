package com.greenjavadude.UniversalAPI.GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	private Key up;
	private Key down;
	private Key left;
	private Key right;
	
	private Key w;
	private Key a;
	private Key s;
	private Key d;
	
	private Key spacebar;
	private Key enter;
	private Key shift;
	
	public InputHandler(){
		up = new Key();
		down = new Key();
		left = new Key();
		right = new Key();
		
		w = new Key();
		a = new Key();
		s = new Key();
		d = new Key();
		
		spacebar = new Key();
		enter = new Key();
		shift = new Key();
	}
	
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void toggleKey(int keyCode, boolean b){
		switch(keyCode){
		
		case KeyEvent.VK_UP:
			up.setPressed(b);
			break;
		case KeyEvent.VK_DOWN:
			down.setPressed(b);
			break;
		case KeyEvent.VK_LEFT:
			left.setPressed(b);
			break;
		case KeyEvent.VK_RIGHT:
			right.setPressed(b);
			break;
		case KeyEvent.VK_W:
			w.setPressed(b);
			break;
		case KeyEvent.VK_A:
			a.setPressed(b);
			break;
		case KeyEvent.VK_S:
			s.setPressed(b);
			break;
		case KeyEvent.VK_D:
			d.setPressed(b);
			break;
		case KeyEvent.VK_SPACE:
			spacebar.setPressed(b);
			break;
		case KeyEvent.VK_ENTER:
			enter.setPressed(b);
			break;
		case KeyEvent.VK_SHIFT:
			shift.setPressed(b);
			break;
		default:
			break;
		}
	}
	
	public boolean isUp(){
		return up.getPressed();
	}
	
	public boolean isDown(){
		return down.getPressed();
	}
	
	public boolean isLeft(){
		return left.getPressed();
	}
	
	public boolean isRight(){
		return right.getPressed();
	}
	
	public boolean isW(){
		return w.getPressed();
	}
	
	public boolean isA(){
		return a.getPressed();
	}
	
	public boolean isS(){
		return s.getPressed();
	}
	
	public boolean isD(){
		return d.getPressed();
	}
	
	public boolean isSpacebar(){
		return spacebar.getPressed();
	}
	
	public boolean isEnter(){
		return enter.getPressed();
	}
	
	public boolean isShift(){
		return shift.getPressed();
	}
}