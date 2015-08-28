package com.greenjavadude.UniversalAPI.GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	private boolean w;
	private boolean a;
	private boolean s;
	private boolean d;
	
	private boolean spacebar;
	private boolean enter;
	private boolean backspace;
	
	private boolean shift;
	private boolean ctrl;
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_W:
			w = true;
			break;
		case KeyEvent.VK_A:
			a = true;
			break;
		case KeyEvent.VK_S:
			s = true;
			break;
		case KeyEvent.VK_D:
			d = true;
			break;
		case KeyEvent.VK_SPACE:
			spacebar = true;
			break;
		case KeyEvent.VK_ENTER:
			enter = true;
			break;
		case KeyEvent.VK_BACK_SPACE:
			backspace = true;
			break;
		case KeyEvent.VK_SHIFT:
			shift = true;
			break;
		case KeyEvent.VK_CONTROL:
			ctrl = true;
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_W:
			w = false;
			break;
		case KeyEvent.VK_A:
			a = false;
			break;
		case KeyEvent.VK_S:
			s = false;
			break;
		case KeyEvent.VK_D:
			d = false;
			break;
		case KeyEvent.VK_SPACE:
			spacebar = false;
			break;
		case KeyEvent.VK_ENTER:
			enter = false;
			break;
		case KeyEvent.VK_BACK_SPACE:
			backspace = false;
			break;
		case KeyEvent.VK_SHIFT:
			shift = false;
			break;
		case KeyEvent.VK_CONTROL:
			ctrl = false;
			break;
		}
	}
	
	public boolean isUp() {
		return up;
	}
	
	public boolean isDown() {
		return down;
	}
	
	public boolean isLeft() {
		return left;
	}
	
	public boolean isRight() {
		return right;
	}
	
	public boolean isW() {
		return w;
	}
	
	public boolean isA() {
		return a;
	}
	
	public boolean isS() {
		return s;
	}
	
	public boolean isD() {
		return d;
	}
	
	public boolean isSpacebar() {
		return spacebar;
	}
	
	public boolean isEnter() {
		return enter;
	}
	
	public boolean isBackspace() {
		return backspace;
	}
	
	public boolean isShift() {
		return shift;
	}
	
	public boolean isCtrl() {
		return ctrl;
	}
}