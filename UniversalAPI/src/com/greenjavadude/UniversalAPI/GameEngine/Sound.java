package com.greenjavadude.UniversalAPI.GameEngine;

import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound {
	public static final int SINGLE = 0;
	public static final int LOOP = 1;
	
	private boolean running;
	private boolean paused;
	private File file;
	
	private MediaPlayer mp;
	
	public Sound(File file, int mode){
		this.file = file;
		running = false;
		paused = false;
		
		JFXPanel panel = new JFXPanel();
		panel.setEnabled(false);
		Media media = new Media(this.file.toURI().toString());
		mp = new MediaPlayer(media);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				stopP();
			}
		});
	}
	
	public synchronized void play(){
		running = true;
		paused = false;
		mp.play();
	}
	
	public synchronized void stop(){
		running = false;
		paused = false;
		mp.stop();
		mp.dispose();
	}
	
	public synchronized void pause(){
		if(running && !paused){
			paused = true;
			mp.pause();
		}
	}
	
	public synchronized void skipTo(double d){
		Duration dur = new Duration(d*1000);
		
		if(mp == null){
			return;
		}
		
		if(mp.getTotalDuration().greaterThan(dur)){
			mp.seek(dur);
		}
	}
	
	public double getTotalDuration(){
		return mp.getTotalDuration().toSeconds();
	}
	
	private synchronized void stopP(){
		stop();
	}
}