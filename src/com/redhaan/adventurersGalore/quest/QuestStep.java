package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.party.travelerEvent.DialogueText;
import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.town.Towns;

import gameEngine.ecclesiastes.GameContainer;

public class QuestStep  {
	
	public QuestStepLocation questStepLocation;
	public int maxDays;
	public int daysPassed;
	public ArrayList<DialogueText> playerGetsEmptyQuestInTown;
	public ArrayList<DialogueText> playerGetsEmptyQuestInWorldMap;
	public ArrayList<DialogueText> playerGetsTakenQuestInTown;
	public ArrayList<DialogueText> playerGetsTakenQuestInWorldMap;
	protected boolean waitingAtLocation;
	public int adventurerGenderXOffset;
	public int adventurerGenderYOffset;



	public QuestStep() {
		
		questStepLocation = new QuestStepLocation();
		playerGetsEmptyQuestInTown = new ArrayList<DialogueText>();
		playerGetsEmptyQuestInWorldMap = new ArrayList<DialogueText>();
		playerGetsTakenQuestInTown = new ArrayList<DialogueText>();
		playerGetsTakenQuestInWorldMap = new ArrayList<DialogueText>();
		waitingAtLocation = false;
		adventurerGenderXOffset = 0;
		adventurerGenderYOffset = 0;
		
	}

	
	public void update(GameContainer gameContainer, Quest quest) {
		
	}
	
	public boolean activateNextQuestStep(Quest quest) {
		
		Random random = new Random();
		if (random.nextInt(quest.maxPartySize) + 1 <= quest.questParty.size()) { return true; }
		return false;
		
	}
	
	public boolean partyArrivedAtNewQuestStepLocation(Quest quest, QuestStep questStep) {
		
		int averageTravelSpeed = calculateAverageSpeed(quest.questParty);
		int horizontalDistance = Math.abs(quest.questParty.get(0).mapX - questStep.questStepLocation.questLocationTown.xLocations[0]);
		int verticalDistance = Math.abs(quest.questParty.get(0).mapY - questStep.questStepLocation.questLocationTown.yLocations[0]);
		int totalDistance = horizontalDistance + verticalDistance;
		int timeToTravel1Tile = 10;
		int averageTerrainModifier = 9;
		
		int daysToTravel = totalDistance * timeToTravel1Tile / averageTravelSpeed * 10 / averageTerrainModifier;
		
		if(questStep.daysPassed >= daysToTravel) {
			for (Adventurer adventurer: quest.questParty) {
				adventurer.mapX = questStep.questStepLocation.questLocationTown.xLocations[0];
				adventurer.mapY = questStep.questStepLocation.questLocationTown.yLocations[0];
				return true;
			}
		}
		
		return false;
	} 
	
	private int calculateAverageSpeed(ArrayList<Adventurer> adventurers) {
		
		int average = 0;
		for (Adventurer adventurer: adventurers) { average = average + adventurer.maxStats.travelSpeed; }
		average = average / adventurers.size();
		return average;
		
	}
	
	
	
	public void createNextQuestStep (QuestStep questStep, Quest quest) {
		quest.questSteps.remove(0);
		quest.questSteps.add(questStep);
	}
		
	public Town rollForQuestStepLocationTown() {
		Random random = new Random();
		int roll = random.nextInt(Towns.allTowns.size());
		return Towns.allTowns.get(roll);	
	}
	
	
	public boolean playerInterceptsQuest(Quest quest) {
		
		boolean intercepts = false;
		if (quest.questParty.size() > 0) {
			boolean xOkay = false;
			if(quest.questParty.get(0).mapX < GameManager.adventurers.allAdventurers.get(0).mapX &&
					GameManager.adventurers.allAdventurers.get(0).mapX < quest.questSteps.get(0).questStepLocation.questLocationTown.xLocations[0]) { 
				xOkay = true; }
			else if(quest.questParty.get(0).mapX > GameManager.adventurers.allAdventurers.get(0).mapX &&
					GameManager.adventurers.allAdventurers.get(0).mapX > quest.questSteps.get(0).questStepLocation.questLocationTown.xLocations[0]) { 
				xOkay = true; }
			boolean yOkay = false;
			if(quest.questParty.get(0).mapY < GameManager.adventurers.allAdventurers.get(0).mapY &&
					GameManager.adventurers.allAdventurers.get(0).mapY < quest.questSteps.get(0).questStepLocation.questLocationTown.yLocations[0]) { 
				yOkay = true; }
			else if(quest.questParty.get(0).mapY > GameManager.adventurers.allAdventurers.get(0).mapY &&
					GameManager.adventurers.allAdventurers.get(0).mapY > quest.questSteps.get(0).questStepLocation.questLocationTown.yLocations[0]) { 
				yOkay = true; }
			
			if(xOkay && yOkay) {
				intercepts = true;
			}			
		}
		return intercepts;
	}
	


	

	
}
