package com.redhaan.adventurersGalore.entity.adventurer.personality;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class ConversationTable {

	
	public static Conversation rollConversation(ArrayList<Adventurer> candidates) {
		
		Random random = new Random();
		ArrayList<FakeNr> conversations = new ArrayList<FakeNr>();
				
		int speaker1 = random.nextInt(candidates.size());
		int speaker2 = 9998;
		int speaker3 = 9999;
		boolean goOn = true;
		while(goOn) {
			speaker2 = random.nextInt(candidates.size());
			if(speaker1 != speaker2) { goOn = false; }
		}
		goOn = true;
		while(goOn) {
			speaker3 = random.nextInt(candidates.size());
			if(speaker1 != speaker2 && speaker1!= speaker3 && speaker2 != speaker3) { goOn = false;	}
		}
		
		if(candidates.get(speaker1).personality.traits.contains(PersonalityTrait.Pedantic)
				&& candidates.get(speaker2).personality.traits.contains(PersonalityTrait.Drunk)) {
			conversations.add(new FakeNr(1));
		}
		
		if(candidates.get(speaker1).personality.traits.contains(PersonalityTrait.Pedantic)
				&& candidates.get(speaker2).personality.traits.contains(PersonalityTrait.Cynical)) {
			conversations.add(new FakeNr(2));
		}
		
		if(candidates.get(speaker1).personality.traits.contains(PersonalityTrait.Pedantic)
				&& candidates.get(speaker2).personality.traits.contains(PersonalityTrait.Witty)) {
			conversations.add(new FakeNr(3));
		}
		
		if(candidates.get(speaker1).personality.traits.contains(PersonalityTrait.Pedantic)
				&& candidates.get(speaker2).personality.traits.contains(PersonalityTrait.Pedantic)) {
			conversations.add(new FakeNr(4));
		}
		
		if(candidates.get(speaker1).personality.traits.contains(PersonalityTrait.Witty)) {
			conversations.add(new FakeNr(5));
		}
		
		if(candidates.get(speaker1).personality.traits.contains(PersonalityTrait.Drunk)) {
			conversations.add(new FakeNr(6));
		}
		
		if(candidates.get(speaker1).personality.traits.contains(PersonalityTrait.Cynical)) {
			conversations.add(new FakeNr(7));
		}
		
		
		
		ArrayList<Adventurer> talkers = new ArrayList<Adventurer>();
		talkers.add(candidates.get(speaker1));
		talkers.add(candidates.get(speaker2));
		talkers.add(candidates.get(speaker3));
		if(conversations.size() > 0) {
			Conversation conversation = createConversation(conversations, talkers);
			return conversation;
		}

		return null;		
			
	}
	
	
	private static Conversation createConversation(ArrayList<FakeNr> conversations, ArrayList<Adventurer> talkers) {
		
		Conversation conversation = new Conversation();
		
		Random random = new Random();
		int roll = random.nextInt(conversations.size());
		switch(conversations.get(roll).number) {
		
		case 1:
			conversation.lines.add(new Line("this one guy is being pedantic and you know it's bothering us a lot. But ok. It is what it is I guess, nothing to do", 0));
			conversation.lines.add(new Line("and the other guy is drunk", 1));
			conversation.talkers = talkers;
			return conversation;
		
		case 2:
			conversation.lines.add(new Line("this one guy is being pedantic and you know it's bothering us a lot. But ok. It is what it is I guess, nothing to do", 0));
			conversation.lines.add(new Line("and the other guy is cynical", 1));
			conversation.talkers = talkers;
			return conversation;
			
		case 3:
			conversation.lines.add(new Line("this one guy is being pedantic and you know it's bothering us a lot. But ok. It is what it is I guess, nothing to do", 0));
			conversation.lines.add(new Line("and the other guy is witty", 1));
			conversation.talkers = talkers;
			return conversation;
			
		case 4:
			conversation.lines.add(new Line("this one guy is being pedantic and you know it's bothering us a lot. But ok. It is what it is I guess, nothing to do", 0));
			conversation.lines.add(new Line("and the other guy is pedantic as well", 1));
			conversation.talkers = talkers;
			return conversation;
			
		case 5:
			conversation.lines.add(new Line("this one guy is being witty", 0));
			conversation.lines.add(new Line("and the other guy doesn't matter", 1));
			conversation.talkers = talkers;
			return conversation;
			
		case 6:
			conversation.lines.add(new Line("this one guy is being drunk", 0));
			conversation.lines.add(new Line("and the other guy doesn't matter", 1));
			conversation.talkers = talkers;
			return conversation;
			
		case 7:
			conversation.lines.add(new Line("this one guy is being cynical", 0));
			conversation.lines.add(new Line("and the other guy doesn't matter", 1));
			conversation.talkers = talkers;
			return conversation;
			
		default:
			conversation.lines.add(new Line("this one guy is a default", 0));
			conversation.lines.add(new Line("and the other guy is a default as well", 1));
			conversation.talkers = talkers;
			return conversation;
		
		}
		
	}
	
	
	
	
}
