package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameObject;
import com.redhaan.adventurersGalore.calendar.Calendar;
import com.redhaan.adventurersGalore.quest.questUI.QuestUI;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.Renderer;

public class Quests extends GameObject {

	private static final long serialVersionUID = 1L;
	public static ArrayList<Quest> allQuests;
	private int day;
	public static boolean playerInteractedWithQuestRecently;
	private int questsToBeAdded;

	public Quests() {

		Random random = new Random();
		allQuests = new ArrayList<Quest>();
		for (int i = 0; i < 2; i++) {
			int questRoll = random.nextInt(1);
			Quest questToBeAdded = QuestTable.rollQuest(questRoll);
			allQuests.add(questToBeAdded);
		}
		QuestUI.quest = allQuests.get(0);
		day = 0;
		questsToBeAdded = 0;
		
		playerInteractedWithQuestRecently = false;

	}

	@Override
	public void update(GameContainer gameContainer, float deltaTime) {
		
		if(questsToBeAdded > 0 && GameContainer.fps > 58) {
			Quest questToBeAdded = QuestTable.rollQuest(0);
			allQuests.add(questToBeAdded);
			questsToBeAdded--;			
		}

		switch (GameManager.gameState) {


		default: break;
		case Combat: break;
		case PartyScreen: break;
		case Titlescreen: break;

		case WorldMap:
			if (day == Calendar.daysPassed) {
				for (int i = 0; i < allQuests.size(); i++) {
					if (allQuests.get(i).questSteps.get(0).daysPassed > allQuests.get(i).questSteps.get(0).maxDays ) {
						allQuests.remove(i);
						questsToBeAdded++;
						i--;
					}
					else {
						allQuests.get(i).update(gameContainer, deltaTime);
					}
				}
				day++;
				playerInteractedWithQuestRecently = false;
			}
			break;
			
		case InTown:
			if(!playerInteractedWithQuestRecently) {
			ArrayList<Quest> questsInThisTown = new ArrayList<Quest>();
			for (Quest quest : allQuests) {
				boolean xMatch = false;
				boolean yMatch = false;
				for (int i = 0; i < quest.questSteps.get(0).questStepLocation.questLocationTown.xLocations.length; i++) {
					if (quest.questSteps.get(0).questStepLocation.questLocationTown.xLocations[i] == GameManager.adventurers.allAdventurers.get(0).mapX) {
						xMatch = true;
					}
				}
				for (int i = 0; i < quest.questSteps.get(0).questStepLocation.questLocationTown.yLocations.length; i++) {
					if (quest.questSteps.get(0).questStepLocation.questLocationTown.yLocations[i] == GameManager.adventurers.allAdventurers.get(0).mapY) {
						yMatch = true;
					}
				}
				if(xMatch && yMatch) {
					questsInThisTown.add(quest);
				}
			}
			if(questsInThisTown.size() > 0) {
				Random random = new Random();
				int roll = random.nextInt(questsInThisTown.size());
				playerInteractedWithQuestRecently = true;
				questsInThisTown.get(roll).update(gameContainer, deltaTime);				
			}
			}
						
			break;
		}
	}

	@Override
	public void render(GameContainer gameContainer, Renderer renderer) {

	}

}
