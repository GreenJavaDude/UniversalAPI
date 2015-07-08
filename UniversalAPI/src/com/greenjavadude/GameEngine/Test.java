package com.greenjavadude.GameEngine;

import java.awt.Graphics2D;

public class Test extends Engine{
	/**@author Green Java Dude
	 * 
	 * An example program that is explained.
	 */
	
	private static final long serialVersionUID = 1L;
	
	private SpriteSheet spriteSheet;
	
	public Test(String title, int width, int height){
		super(title, width, height);
		
		//this means: the spritesheet is made out of small images, each 16x16 pixels
		//the spritesheet is 10 small images wide and 10 high
		//(open res/SpriteSheet16x16.png and you'll get it)
		spriteSheet = new SpriteSheet("res//SpriteSheet16x16.png", 16, 16, 10, 10);
	}
	
	public void draw(Graphics2D g){
		//draw stuff from the spritesheet
		g.drawImage(spriteSheet.getImage(1), 100, 300, null);
		g.drawImage(spriteSheet.getImage(0), 100, 150, null);
	}
	
	public static void main(String[] args){
		Test engine = new Test("A Test Program", 800, 500);
		//Sound sound = new Sound();
		
		//sound.play("insert .wav path here", SoundMode.LOOP);
		engine.start();
		
		try{
			Thread.sleep(10000);
		}catch(Exception e){
			
		}
		
		//sound.stop();
		engine.stop();
		//engine.stop() must be called last as it exits the program
	}
}