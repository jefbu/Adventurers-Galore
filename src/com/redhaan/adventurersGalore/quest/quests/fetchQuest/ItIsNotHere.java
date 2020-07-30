package com.redhaan.adventurersGalore.quest.quests.fetchQuest;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.combat.Combat;
import com.redhaan.adventurersGalore.combat.CombatPhase;
import com.redhaan.adventurersGalore.combat.combatAI.HighLevelPlan;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.quest.Quest;
import com.redhaan.adventurersGalore.quest.QuestStep;
import com.redhaan.adventurersGalore.quest.questUI.QuestUI;

import gameEngine.ecclesiastes.GameContainer;
import gameEngine.ecclesiastes.gfx.ImageTile;

public class ItIsNotHere extends QuestStep {
	
	public ItIsNotHere(Town town) {

		daysPassed = 0;
		maxDays = 50;
		questStepLocation.questLocationTown = town;
		questStepLocation.nextLocationTown = rollForQuestStepLocationTown();

		playerGetsEmptyQuestInTown.add("Empty in town It Is Not Here");
		playerGetsEmptyQuestInTown.add("Second Line");	
		
		playerGetsTakenQuestInTown.add("Taken in town It Is Not Here");
		
		playerGetsEmptyQuestInWorldMap.add("Empty It is not here step found in the worldmap");
		playerGetsEmptyQuestInWorldMap.add("Second page");
		
		playerGetsTakenQuestInWorldMap.add("Already taken It is not here found on the map!");
		
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
							QuestUI.monsters.add(new Monster());
							QuestUI.monsters.add(new Monster());
							QuestUI.monsters.get(0).icon = new ImageTile("/Monsters.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
							QuestUI.monsters.get(1).icon = new ImageTile("/Monsters.png", GameManager.GAMETILESIZE, GameManager.GAMETILESIZE);
							QuestUI.monsters.get(0).currentStats.move = 3;
							QuestUI.monsters.get(1).currentStats.move = 7;
							QuestUI.monsters.get(0).currentStats.attack = 40;
							QuestUI.monsters.get(1).currentStats.attack = 140;
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
