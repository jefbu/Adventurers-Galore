package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;

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
		/*
		if(!quest.playerQuest) {
			if(!waitingAtLocation) {
				if(partyArrivedAtNewQuestStepLocation(quest, this)) {
					waitingAtLocation = true;
				}
				else { playerInterceptsQuest(quest); }
			}
			
			if(waitingAtLocation) {			
				quest.conclude();
				daysPassed = 999;
			}
		}
		*/
		daysPassed++;
		
	}
	
	
}
