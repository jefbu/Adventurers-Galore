package com.redhaan.adventurersGalore.entity.party;

import java.io.Serializable;
import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.Transition;

import gameEngine.ecclesiastes.GameContainer;

public class PartyCohesionChecker implements Serializable {

	private static final long serialVersionUID = 1L;
	private int partySize;
	private Random random;
	//private PartyCohesionCheckerUI partyCohesionCheckerUI;	
	
	public PartyCohesionChecker() {
		
		partySize = 0;
		random = new Random();
		//partyCohesionCheckerUI = new PartyCohesionCheckerUI();
		
	}
	
	
	public void checkDailyPartyCohesion(int penalty, GameContainer gameContainer) {		
		
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
					if(roll + penalty < GameManager.adventurers.allAdventurers.get(i).currentStats.TST) {
						deletables[i] = false;
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
					}
				}
				int finalRoll = random.nextInt(finalCandidates.length);
				int deletableAdventurer = finalCandidates[finalRoll];
				GameManager.adventurers.allAdventurers.get(deletableAdventurer).inParty = false;
				PartyCohesionCheckerUI.adventurer = GameManager.adventurers.allAdventurers.get(deletableAdventurer);
				PartyCohesionCheckerUI.nextGameState = GameState.WorldMap;
				Transition.nextGameState = GameState.PartyCohesionCheckerUI;
				GameManager.gameState = GameState.Transition;

			}
		}
		
		partySize = 0;

	
	}
	
	
	public void checkNewQuestPartyCohesion(GameContainer gameContainer, GameState questAcceptedGameState) {
		
		int tierZeroes = 0;
		boolean[] deletables = new boolean[GameManager.adventurers.allAdventurers.size()];
		
		for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
			if (GameManager.adventurers.allAdventurers.get(i).inParty) { 
				if (GameManager.adventurers.allAdventurers.get(i).tier == 0) {
					deletables[i] = true;
					tierZeroes++;
				}
			}			
		}
		
		if(tierZeroes > 1) {
			for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {
				if(deletables[i]) {
					int roll = random.nextInt(100);
					if(roll < GameManager.adventurers.allAdventurers.get(i).currentStats.TST) {
						deletables[i] = false;
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
					}
				}
				int finalRoll = random.nextInt(finalCandidates.length);
				int deletableAdventurer = finalCandidates[finalRoll];
				GameManager.adventurers.allAdventurers.get(deletableAdventurer).inParty = false;
				PartyCohesionCheckerUI.nextGameState = questAcceptedGameState;
				PartyCohesionCheckerUI.adventurer = GameManager.adventurers.allAdventurers.get(deletableAdventurer);
				Transition.nextGameState = GameState.PartyCohesionCheckerUI;
				GameManager.gameState = GameState.Transition;
				checkDailyPartyCohesion(10, gameContainer);
				
			}
		}				
		
	}

}
