package com.redhaan.adventurersGalore.entity.town;

import java.util.ArrayList;
import java.util.Random;

public class ConversationLibrary {
	
	
	public ArrayList<String> conversations;
	private Random random;
	
	
	public ConversationLibrary() {
		
		conversations = new ArrayList<String>();
		random = new Random();
		createConversations();
		
	}
	
	
	
	
	public String getActiveConversation() {
		
		return conversations.get(0); 
		
	}
	
	
	
	private void createConversations() {
		
		conversations.add("this is the first conversation, extended to fit into more than one line of text, ideally it goes up to three lines to get a feeling of how many words this boils down to");
		conversations.add("this is the second conversation");
		
	}
	
	
	private String getEmptyConversation() {
		
		int roll = random.nextInt(3);
		
		switch (roll) {
		
		case 0: return "I have nothing to add at this moment";
		case 1: return "Oh it's you again, how have you been?";
		case 2: return "Hello again"; 
		
		default: return "error at empty conversation";
		
		
		}
		
	}

}
