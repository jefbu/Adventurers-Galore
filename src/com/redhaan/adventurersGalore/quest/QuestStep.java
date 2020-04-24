package com.redhaan.adventurersGalore.quest;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.town.Towns;

import gameEngine.ecclesiastes.GameContainer;

public class QuestStep  {
	
	public QuestLocationType questLocationType;
	public Town questLocationTown;
	public boolean inInn;
	int[] xLocations;
	int[] yLocations;

	public QuestStep() {
		
	}

	
	public void update(GameContainer gameContainer, Quest quest) {
		
	}

	
	public void decideQuestStepLocation(QuestLocationType questLocationType, QuestStep questStep) {
		
		Random random = new Random();
		
		switch (questLocationType) {
		case CloseToTown:
			break;
		case InInn:
			break;
		case InTown:
			int roll = random.nextInt(Towns.allTowns.size());
			questStep.questLocationTown = Towns.allTowns.get(roll);
			break;
		default:
			break;
		
		}
		
	}	
	
}
