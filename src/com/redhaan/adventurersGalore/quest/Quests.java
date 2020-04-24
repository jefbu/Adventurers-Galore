package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Quests extends GameObject {
	
	public ArrayList<Quest> allQuests;
	
	public Quests() {
		
		Random random = new Random();
		allQuests = new ArrayList<Quest>();
		for (int i = 0; i < 3; i++) {
			int questRoll = random.nextInt(2);
			Quest questToBeAdded = QuestTable.rollQuest(questRoll);
			allQuests.add(questToBeAdded);
		}
		
	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		switch(GameManager.gameState) {
		
		case Combat: break;
		case InTown: break;
		case PartyScreen: break;
		case Titlescreen: break;
		
		case WorldMap:
			for (Quest quest: allQuests) {
				quest.update(gameContainer, deltaTime);
			}			
			break;
		
		
		default: break;
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {
		
	}

}
