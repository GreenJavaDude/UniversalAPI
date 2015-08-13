package com.greenjavadude.UniversalAPI.GameEngine;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound implements Runnable{
	public static final int SINGLE = 0;
	public static final int LOOP = 1;
	
	private File file;
	private int mode;
	private MediaPlayer mp;
	
	public void run(){
		if(mode == 1){
			mp.setCycleCount(MediaPlayer.INDEFINITE);
			mp.play();
		}
		if(mode == 0){
			mp.play();
			this.stop();
		}
	}
	
	public void play(String path, int mode){
		file = new File(path);
		this.mode = mode;
		try{
			//this is used to initialize some stuff for the music
			//the music is from the javafx package so this is necessary
			JFXPanel panel = new JFXPanel();
			panel.setEnabled(false);//if i don't use it's yellow
			
			Media media = new Media(file.toURI().toString());
			mp = new MediaPlayer(media);
			
			new Thread(this).start();
		}catch(Exception e){
			System.out.println("Couldn't initialize music. (Wrong file?)");
		}
	}
	
	public void stop(){
		mp.stop();
		file = null;
		mp.dispose();
	}
}