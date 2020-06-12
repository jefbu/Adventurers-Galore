package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;
import com.redhaan.adventurersGalore.quest.questUI.QuestUI;

import gameEngine.ecclesiastes.GameContainer;

public class GoGetMyTrinket extends QuestStep {
	
	public GoGetMyTrinket() {
		daysPassed = 0;
		maxDays = 50;
		questStepLocation.questLocationTown = rollForQuestStepLocationTown();
		questStepLocation.nextLocationTown = rollForQuestStepLocationTown();
		
		playerGetsEmptyQuestInTown.add("A trinket lost, and lost to me. Perchance for all eternity. "
				+ "Unless thee heedst my tear-eyed plea, and soothe my poignant mysery. "
				+ "And bring that trinket back to me.");
		playerGetsEmptyQuestInTown.add("Well how hast lost thine joie de vivre?");
		playerGetsEmptyQuestInTown.add("It was in drunken revelry...");
		playerGetsEmptyQuestInTown.add("I see...");

		playerGetsEmptyQuestInTown.add("Thou shallst find it in " + questStepLocation.nextLocationTown.name);
		playerGetsEmptyQuestInTown.add("Good luck!");
		
		
		playerGetsTakenQuestInTown.add("That there drunken lout, hast gone too far out and about. " 
				+ "The token of his marriage proud, ist some unknownst and hidden route. "
				+ "What sayest thee, o warrior stout, willst help us ease a husband's doubt?");
		
		playerGetsEmptyQuestInWorldMap.add("Empty Go Get My Trinket step found in the worldmap");
		playerGetsEmptyQuestInWorldMap.add("Second page");
		
		playerGetsTakenQuestInWorldMap.add("Already taken Go get my trinket found on the map!");
		
	}
	
	
	@Override
	public void update(GameContainer gameContainer, Quest quest) {
		
		Random random = new Random();
				
		switch(GameManager.gameState) {
				
		case Combat: break;
		case PartyScreen: break;
		case Titlescreen: break;
		default: break;	
		
		case InTown:
				QuestUI.quest = quest;
				QuestUI.previousGameState = GameState.InTown;
				GameManager.gameState = GameState.QuestUI;
				if(random.nextBoolean()) { QuestUI.nextQuestStep = new ItIsNotHere(questStepLocation.nextLocationTown); }
				else { QuestUI.nextQuestStep = new YouFoundIt(questStepLocation.nextLocationTown); }
			break;
			
		case WorldMap:
			
			if(!quest.playerQuest) {
				if(activateNextQuestStep(quest)) {
					if(random.nextBoolean()) { createNextQuestStep(new ItIsNotHere(questStepLocation.nextLocationTown), quest); }
					else { createNextQuestStep(new YouFoundIt(questStepLocation.nextLocationTown), quest); }
				}
				
				else if(quest.questParty.size() < quest.maxPartySize) {
					questStepLocation.checkAvailableAdventurers(questStepLocation.questLocationTown, quest);		
				}
			}
					
			daysPassed++;
			break;
		
		}
		
	}

}
