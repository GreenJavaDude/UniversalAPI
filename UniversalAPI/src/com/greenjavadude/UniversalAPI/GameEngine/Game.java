package com.greenjavadude.UniversalAPI.GameEngine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
	private static final long serialVersionUID = -166158607859089550L;
	private boolean running;
	private int width;
	private int height;
	private InputHandler input;
	
	public Game(String title, int width, int height){
		running = false;
		this.width = width;
		this.height = height;
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		input = new InputHandler();
		frame.addKeyListener(input);
		
		frame.add(this);
		frame.setVisible(true);
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
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		BufferedImage image = (BufferedImage) createImage(width, height);
		Graphics2D g2d = image.createGraphics();
		
		draw(g2d);
		g.drawImage(image, 0, 0, null);
		
		g.dispose();
		if(g2d != null){
			g2d.dispose();
		}
	}
	
	public synchronized void draw(Graphics2D g){
		
	}
	
	public synchronized void start(){
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop(){
		running = false;
	}
}