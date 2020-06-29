package com.redhaan.adventurersGalore.entity.party;

import java.util.ArrayList;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public class PartyCohesionChecker {
	
	private int partySize;
	private Random random;
	
	public PartyCohesionChecker() {
		
		partySize = 0;
		random = new Random();
		
	}
	
	
	public void checkDailyPartyCohesion() {
		
		boolean atLeastOne = false;
		boolean[] deletables = new boolean[GameManager.adventurers.allAdventurers.size()];
		
		for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
			if (GameManager.adventurers.allAdventurers.get(i).inParty) { 
				partySize++;
				if (GameManager.adventurers.allAdventurers.get(i).currentStats.TST < 80 && GameManager.adventurers.allAdventurers.get(i).tier > 0) {
					deletables[i] = true;
					atLeastOne = true;
				}
			}			
		}
						
		System.out.println("there are " + partySize + " adventurers in the party");
	
		if(partySize > 4 && atLeastOne) {
			for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
				if(deletables[i]) {
					int roll = random.nextInt(100);
					switch (partySize) {
					case 5: roll -= 40; break;
					case 6: roll -= 20; break;
					case 8: roll += 20; break;
					default: roll += 40; break;
					}
					if(roll < GameManager.adventurers.allAdventurers.get(i).currentStats.TST) {
						deletables[i] = false;
					}
				}
			}
		}
		
		int finalAmount = 0;
		for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
			if (deletables[i]) { finalAmount++; }
		}
		
		if(finalAmount > 0) {
			int[] finalCandidates = new int[finalAmount];
			
			int counter = 0;
			for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
				if (deletables[i]) {
					finalCandidates[counter] = i;
					counter++;
					System.out.println("Final Deletable Adventurer at array position: " + i);
				}
			}
			System.out.println("Final Candidates length: " + finalCandidates.length);
			int finalRoll = random.nextInt(finalCandidates.length);
			int deletableAdventurer = finalCandidates[finalRoll];
			GameManager.adventurers.allAdventurers.get(deletableAdventurer).inParty = false;
		}

		
		
		

		partySize = 0;

	
	}

}
