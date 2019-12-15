package com.redhaan.adventurersGalore.combat;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class Deployer {
	
	
	public static void deploy() {
		
		Random random = new Random();
		boolean finished = false;
		
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			
			adventurer.setCombatX(0);
			adventurer.setCombatY(0);
			
			if(adventurer.inParty) {
			
			finished = false;
			
			while(!finished) {
			
			adventurer.setCombatX(random.nextInt(5) + 1);
			adventurer.setCombatY(random.nextInt(5) + 9);

			int counter = 0;
			
			for (int i = 0; i < GameManager.adventurers.allAdventurers.size(); i++) {

				if (GameManager.adventurers.allAdventurers.get(i).getCombatX() == adventurer.getCombatX()) {
					if (GameManager.adventurers.allAdventurers.get(i).getCombatY() == adventurer.getCombatY()) {
						counter++;
					}
				}
			}
			if (counter < 2) { finished = true; }
			}
			
			}
		}
		
	}

}
