package com.greenjavadude.GameEngine;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Engine extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private boolean running;
	private int width;
	private int height;
	private InputHandler inputHandler;
	
	public Engine(String title, int width, int height){
		running = false;
		this.width = width;
		this.height = height;
		JFrame frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		this.setSize(width, height);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputHandler = new InputHandler();
		frame.addKeyListener(inputHandler);
	}
	
	public void run(){
		try{
			while(running){
				repaint();
				
				Thread.sleep(5);
			}
		}catch(Exception e){
			
		}
	}
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	public void stop(){
		running = false;
		System.exit(0);
	}
	
	public void draw(Graphics2D g){
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		BufferedImage image = (BufferedImage) this.createImage(width, height);
		Graphics2D gi = image.createGraphics();
		try{
			draw(gi);
		}catch(Exception e){
			//this gets called everytime, idk why but it's working...
		}
		
		g.drawImage(image, 0, 0, null);
		
		g.dispose();
		
		//checks if not already disposed
		if(!gi.equals(null)){
			gi.dispose();
		}
	}
}