package com.redhaan.adventurersGalore.quest;

import java.util.Random;

import com.redhaan.adventurersGalore.entity.town.Town;
import com.redhaan.adventurersGalore.entity.town.Towns;
import com.redhaan.adventurersGalore.entity.town.building.Inn;

public class QuestStep  {
	
	protected QuestLocationType questLocationType;
	protected Town questLocationTown;
	protected Inn inn;
	int[] xLocations;
	int[] yLocations;

	public QuestStep() {
		
	}

	
	public void update(Quest quest) {
		
	}

	
	public void decideInitialQuestStepLocation(QuestLocationType questLocationType, QuestStep questStep) {
		
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
