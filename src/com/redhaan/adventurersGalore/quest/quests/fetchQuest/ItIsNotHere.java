package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.CombatPhase;
import com.redhaan.adventurersGalore.combat.combatAI.HighLevelPlan;
import com.redhaan.adventurersGalore.entity.enemies.Wolf;
import com.redhaan.adventurersGalore.entity.party.travelerEvent.DialogueText;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;
import com.redhaan.adventurersGalore.quest.questUI.QuestUI;

import gameEngine.ecclesiastes.GameContainer;

public class ItIsNotHere extends QuestStep {
	
	public ItIsNotHere(Town town) {

		daysPassed = 0;
		maxDays = 50;
		questStepLocation.questLocationTown = town;
		questStepLocation.nextLocationTown = rollForQuestStepLocationTown();

		playerGetsEmptyQuestInTown.add(new DialogueText("Empty in town It Is Not Here", null, null, 0, 0));
		
		playerGetsTakenQuestInTown.add(new DialogueText("Taken in town It Is Not Here", null, null, 0, 0));
		
		playerGetsEmptyQuestInWorldMap.add(new DialogueText("Empty It is not here step found in the worldmap", null, null, 0, 0));
		
		playerGetsTakenQuestInWorldMap.add(new DialogueText("Already taken It is not here found on the map!", null, null, 0, 0));
		
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
							QuestUI.itsaFight = true;
							QuestUI.enemies.add(new Wolf());
							QuestUI.enemies.add(new Wolf());
							Combat.highLevelPlan = HighLevelPlan.Attack;
							Combat.combatPhase = CombatPhase.Setup;
							QuestUI.nextGameState = GameState.WorldMap;
							GameManager.gameState = GameState.QuestUI;							
						}
					}
				}
				
				if(waitingAtLocation) {			
					if(activateNextQuestStep(quest)) {
						Random random = new Random();
						if(random.nextBoolean()) { createNextQuestStep(new ItIsNotHere(questStepLocation.nextLocationTown), quest); }
						else { createNextQuestStep(new YouFoundIt(questStepLocation.nextLocationTown), quest); }
					}
				}
			}
			break;
			
		case InTown:
			QuestUI.quest = quest;
			QuestUI.nextGameState = GameState.InTown;
			GameManager.gameState = GameState.QuestUI;
			break;	
		
		case Combat: break;		
		case PartyScreen: break;
		case QuestUI: break;
		case Titlescreen: break;
		default: break;	
			
		}
		
		daysPassed++;
		
	}
	

}
