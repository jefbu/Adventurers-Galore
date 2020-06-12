package com.redhaan.adventurersGalore.quest;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.town.Town;

public class QuestStepLocation {

	public QuestLocationType questLocationType;
	public Town questLocationTown;
	public boolean inInn;
	int[] xLocations;
	int[] yLocations;
	
	public Town nextLocationTown;
	
	public QuestStepLocation() {
		
	}
	
	
	
	
	public void checkAvailableAdventurers(Town town, Quest quest) {
		
		ArrayList<Adventurer> candidates = new ArrayList<Adventurer>();
		
		Random random = new Random();
		
		for (int i = 0; i < town.xLocations.length; i++) {
			for (int ii = 0; ii < town.yLocations.length; ii++) {
								
				for (int adv = 1; adv < GameManager.adventurers.allAdventurers.size(); adv++) {
					if (GameManager.adventurers.allAdventurers.get(adv).mapX == town.xLocations[i] 
							&& GameManager.adventurers.allAdventurers.get(adv).mapY == town.yLocations[ii]) {
						candidates.add(GameManager.adventurers.allAdventurers.get(adv));
					}
				}
			
			}
		}
		
		for (Adventurer adventurer: candidates) {
			if(!quest.questParty.contains(adventurer)) {
				int roll = random.nextInt(10) + 1;
				if(roll > 8) { quest.questParty.add(adventurer); }
			}
		}
		
	}	
	
}
