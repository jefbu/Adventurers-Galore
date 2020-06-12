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
	Adventurer speaker;
	ConversationUI conversationUI;
	String conversation;
	
	public Conversations() {
		active = false;
		random = new Random();
		conversationUI = new ConversationUI();
		conversation = "";
	}
	


	@Override
	public void update(GameContainer gameContainer, float deltaTime) {

		switch(GameManager.gameState) {

		case WorldMap:
			
			if(!active) {

				if(random.nextInt(600) == 0) { 
					ArrayList<Adventurer> candidates = new ArrayList<Adventurer>();
					for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
						if(adventurer.inParty) { candidates.add(adventurer); }
					}
					if(candidates.size() > 1) {
						active = true;
						conversationUI.update(gameContainer, deltaTime);
						conversation = ConversationStrings.rollConversation();
						speaker = candidates.get(random.nextInt(candidates.size()));						
					}
				}
				
			} else {
				
				
				
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


	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

		switch(GameManager.gameState) {
		
		case WorldMap:
			if(active) {
				conversationUI.render(gameContainer, renderer);
				renderer.drawImageTile(speaker.icon, conversationUI.offX + 10, conversationUI.offY + 20 , 0, 0);
				renderer.drawText(conversation, conversationUI.offX + 60, conversationUI.offY + 10, 0xffffffff);
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
