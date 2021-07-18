package com.redhaan.adventurersGalore.entity.town.building.seer;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class AdventurerInfoText {

	protected static String totalText;
	private static int clairvoyance = 0;
	
	
	
	protected static void createTotalText (Adventurer adventurer) {
		
		totalText = adventurer.name + " eh, let me tell you what I know. ";
		totalText = totalText +
				"Their home town is: " + adventurer.homeTown.name + ". ";
		totalText = totalText +
				"They are currently in " + adventurer.homeTown.name + ". ";
		/*
		checkClairvoyance();
		
		if (clairvoyance > 0) {
			totalText = totalText +
				". They are training there until the end of the month. /n";
		}
		
		if (clairvoyance > 1) {
			totalText = totalText +
				"Their long term goal is to travel to Ymvernu. /n";
		}
		
		if (clairvoyance > 2) {
			totalText = totalText +
				"They do not trust you much yet. ";
		}
		
		if (clairvoyance > 3) {
			totalText = totalText +
				"However, they seem to be fairly compatible with your current party. /n";
		}
		
		if (clairvoyance > 4) {
			totalText = totalText +
				"They are currently considered a run-of-the-mill level of adventurer. /n";
		}
		
		if (clairvoyance > 5) {
			totalText = totalText +
				"However, they are on of the most talented people on the planet.";
		}
		*/
	}
	
	
	
	protected static String updateTotalText() {
	
		String string = totalText;
				
		return string;
		
	}
	
	
	private static void checkClairvoyance() {
		
		clairvoyance = 0;
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			if (adventurer.inParty) {
				if (adventurer.skills.decorum.activeSkill) {
					if (adventurer.skills.decorum.value > clairvoyance) {
						clairvoyance = adventurer.skills.decorum.value;
					}
				}
			}
		}
		
	}
	
	
}
