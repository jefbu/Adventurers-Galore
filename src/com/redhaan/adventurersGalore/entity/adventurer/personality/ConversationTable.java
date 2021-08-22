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
				&& candidates.get(speaker2).personality.traits.contains(PersonalityTrait.Drunk)) {
			conversations.add(new FakeNr(99));
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
			conversation.lines.add(new Line("You know, I really don't think labile is pronounced that way.", 0));
			conversation.lines.add(new Line("...um...okay?", 1));
			conversation.lines.add(new Line("That clairvoyant we met in that town we stayed.", 0));
			conversation.lines.add(new Line("I really don't get half of what you prattle on about each day.", 1));
			conversation.lines.add(new Line("Well let me...linguistics...but actually...in fact....etymology...", 0));
			conversation.lines.add(new Line("uhu...uhu...uhu...uhu...", 1));
			conversation.lines.add(new Line("*is not paying any attention at all*", 1));
			conversation.lines.add(new Line("And so, that's why they pronounced it wrong.", 0));
			conversation.lines.add(new Line("I need a drink, and I need it strong.", 1));
			conversation.talkers = talkers;
			return conversation;
		
		case 2:
			conversation.lines.add(new Line("You know, I really don't think labile is pronounced that way.", 0));
			conversation.lines.add(new Line("...okay.", 1));
			conversation.lines.add(new Line("That clairvoyant we met in that town we stayed.", 0));
			conversation.lines.add(new Line("I really don't care for what you blabber on about each day.", 1));
			conversation.lines.add(new Line("Well let me...linguistics...but actually...in fact....etymology...", 0));
			conversation.lines.add(new Line("*keeps staring angrily and silently*", 1));
			conversation.lines.add(new Line("*without paying any real attention*", 1));
			conversation.lines.add(new Line("And so, that's why they pronounced it wrong.", 0));
			conversation.lines.add(new Line("What an interesting story. And it sure needed to be this long.", 1));
			conversation.talkers = talkers;
			return conversation;
			//comment
			
		case 99:
			conversation.lines.add(new Line("Ah, that's a good refreshing beer, just what I needed! *wink*", 1));
			conversation.lines.add(new Line("Hey, did you know that beer comes from the old Buyuk word for 'drink'?", 0));
			conversation.lines.add(new Line("...do I have to?", 1));
			conversation.lines.add(new Line("It's also proven that beer drinkers never fall on their front or sides, but always on their back.", 0));
			conversation.lines.add(new Line("Surely that must be quack!", 1));
			conversation.lines.add(new Line("It's true! Look it up!! I'm not a hack!", 0));
			conversation.lines.add(new Line("Ugh. Fine, I promise I will. ...Right after I finish my liquid snack", 1));
			conversation.lines.add(new Line("You should not shy from the opportunity of learning something new you know.", 0));
			conversation.lines.add(new Line("Please just leave me in peace. Just go. Go. ...please", 1));
			conversation.talkers = talkers;
			return conversation;
			
		case 100:
			conversation.lines.add(new Line("Really, must you always be such a walking dictionary know-it-all?", 1));
			conversation.lines.add(new Line("Did you know that dictionaries didn't use to contain simple words? They were quite small!", 0));
			conversation.lines.add(new Line("Initially, they were only to help people understand difficult words, not things already considered known by all!", 0));
			conversation.lines.add(new Line("QED.", 1));
			conversation.lines.add(new Line("Ah, speaking of which, did you know QED originated in mathematics, but a few hundred years ago found its way into philosophy?", 0));
			conversation.lines.add(new Line("Isn't that a bit obvious? Philosophers will pretty much steal any good idea...", 1));
			conversation.lines.add(new Line("Speaking of ideas in philosophy, the Harrican philosopher Pato considered ideas to be kind of perfect blueprints of a thing.", 0));
			conversation.lines.add(new Line("Talking is princely, but silence is king...", 1));
			conversation.lines.add(new Line("Actually, speaking of kings...", 0));
			conversation.lines.add(new Line("*runs away screaming*", 1));
			conversation.talkers = talkers;
			return conversation;
			//zev
			
		default:
			conversation.lines.add(new Line("this one guy is a default", 0));
			conversation.lines.add(new Line("and the other guy is a default as well", 1));
			conversation.talkers = talkers;
			return conversation;
		
		}
		
	}
	
	
	
	
}
