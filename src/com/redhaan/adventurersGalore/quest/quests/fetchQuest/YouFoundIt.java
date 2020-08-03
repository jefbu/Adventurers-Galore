package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;
import com.redhaan.adventurersGalore.quest.questUI.QuestUI;

import gameEngine.ecclesiastes.GameContainer;

public class YouFoundIt extends QuestStep {

	public YouFoundIt(Town town) {
		
		daysPassed = 0;
		maxDays = 50;
		questStepLocation.questLocationTown = town;

		playerGetsEmptyQuestInTown.add("Empty in town You Found It");
		playerGetsEmptyQuestInTown.add("Second Line");	
		
		playerGetsTakenQuestInTown.add("Taken in town You Found It");
		
		playerGetsEmptyQuestInWorldMap.add("Empty You Found It step found in the worldmap");
		playerGetsEmptyQuestInWorldMap.add("Second page");
		
		playerGetsTakenQuestInWorldMap.add("Already taken You Found It found on the map!");
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, Quest quest) {

		switch(GameManager.gameState) {	
		
		case WorldMap:
			if(!quest.playerQuest) {
				if(!waitingAtLocation) {
					if(partyArrivedAtNewQuestStepLocation(quest, this)) {
						waitingAtLocation = true;
					}
					else { 
						if(playerInterceptsQuest(quest)) {
							QuestUI.quest = quest;
							QuestUI.quest.questSteps.add(this);						
						}
					}
				}
				
				if(waitingAtLocation) {			
					daysPassed = daysPassed + 100;
				}
			}
			break;
			
		case InTown: break;	
		case Combat: break;		
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		default: break;	
			
		}
		
		daysPassed++;
		
	}
		
}
