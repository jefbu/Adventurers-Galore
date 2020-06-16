package com.redhaan.adventurersGalore.entity.adventurer.personality;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Conversations extends GameObject {
	
	public static boolean active;
	Random random;
	ConversationUI conversationUI;
	Conversation conversation;
	String stringToBeDrawn;
	String stringToBeDrawnFrom;
	private int timer;
	
	public Conversations() {
		active = false;
		random = new Random();
		conversationUI = new ConversationUI();
		stringToBeDrawn = "";
		stringToBeDrawnFrom = "";
		timer = 0;
	}
	


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch(GameManager.gameState) {

		case WorldMap:
			
			if(!active) {

				if(random.nextInt(60) == 0) { 
					ArrayList<Adventurer> candidates = new ArrayList<Adventurer>();
					for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
						if(adventurer.inParty) { candidates.add(adventurer); }
					}
					if(candidates.size() > 2) {
						active = true;
						conversation = ConversationTable.rollConversation(candidates);
					}
				}
				
			} else {
				
				if(stringToBeDrawnFrom.length() == 0) {
					stringToBeDrawnFrom = conversation.lines.get(conversation.lineNumber).line;
				}
				
				if(stringToBeDrawn.length() != stringToBeDrawnFrom.length()) {
					stringToBeDrawn = stringToBeDrawn + stringToBeDrawnFrom.substring(timer, timer + 1);
					if(timer != stringToBeDrawnFrom.length() - 1) { timer++; }			
				} 

				
				
				
				
			}
			
			conversationUI.update(gameContainer, deltaTime);

			break;
			
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		default: break;
		
		}
		
		
	}


	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch(GameManager.gameState) {
		
		case WorldMap:
			if(active) {
				conversationUI.render(gameContainer, renderer);
				renderer.drawText(stringToBeDrawn, 50, 50, 0xffffffff);
			}
			break;
			
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		case Transition: break;
		default: break;		
				
		}	
		
		
	}

}
