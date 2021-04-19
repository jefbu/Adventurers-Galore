package com.redhaan.adventurersGalore.entity.town;

import java.util.ArrayList;
import java.util.Random;

public class ConversationLibrary {
	
	
	public ArrayList<String> conversations;
	private Random random;
	protected int activeConversation;
	public boolean[] importantLines;
	
	
	public ConversationLibrary() {
		
		conversations = new ArrayList<String>();
		importantLines = new boolean[7];
		random = new Random();
		createConversations();
		activeConversation = 0;
		
	}
	
	
	
	
	public String getActiveConversation() {
		
		return conversations.get(activeConversation);
		
	}
	
	
	
	private void createConversations() {
		
		int amount = 3 + random.nextInt(5);
		for (int i = 0; i < amount; i++) {
			
			int roll = random.nextInt(10) + 1;
			if (roll > 7) { createLine(true, i); }
			else { createLine(false, i); }
			
		}		
	}
	
	private void createLine(boolean important, int i) {
		
		if(important) {
			importantLines[i] = true;
			conversations.add("This is an important line." + " it is array item " + conversations.size());
		}
		else {
			importantLines[i] = false;
			conversations.add("This is not important" + " it is array item " + conversations.size());
		}
		
	}
	
	
	public String getEmptyConversation() {
		
		int roll = random.nextInt(3);
		
		switch (roll) {
		
		case 0: return "I have nothing to add at this moment";
		case 1: return "Oh it's you again, how have you been?";
		case 2: return "Hello again"; 
		
		default: return "error at empty conversation";
		
		
		}
		
	}

}
