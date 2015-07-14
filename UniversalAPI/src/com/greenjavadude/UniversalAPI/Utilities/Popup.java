package com.greenjavadude.UniversalAPI.Utilities;

import javax.swing.JOptionPane;

public class Popup {
	public String askQuestion(String question){
		return JOptionPane.showInputDialog(null, question, "Answer Question", JOptionPane.QUESTION_MESSAGE);
	}
	
	public void inform(String message){
		JOptionPane.showMessageDialog(null, message);
	}
}