package com.redhaan.adventurersGalore.combat;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.enemies.Enemy;

public abstract class Deployer {
	
	public static boolean dungeonDeployEnemies = false;	
		
	
	public static void deploy(int deploySituation) {
		
		
		if (Combat.dungeon) {
			
			Random random = new Random();
			boolean finished = false;
			
			for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
				adventurer.setCombatX(0);
				adventurer.setCombatY(0);
				
				if(adventurer.inParty) {
		
				finished = false;
				
				while(!finished) {
				
				switch (deploySituation) {
				
				case 1: 
					adventurer.setCombatX(random.nextInt(4) + 10);
					adventurer.setCombatY(random.nextInt(4) + 10);
					break;
				case 2:
					adventurer.setCombatX(random.nextInt(3) + 5);
					adventurer.setCombatY(random.nextInt(6) + 5);
					break;
				case 3:
					adventurer.setCombatX(random.nextInt(4) + 10);
					adventurer.setCombatY(random.nextInt(4) + 2);
					break;
				case 4:
					adventurer.setCombatX(random.nextInt(4) + 15);
					adventurer.setCombatY(random.nextInt(6) + 5);
					break;
				}

		
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
			
			
			if(dungeonDeployEnemies) {
				
				for (Enemy enemy: Combat.enemies) {
					
					boolean finished2 = false;
					while(!finished2) {
						
						switch (deploySituation) {
						
						case 1: 
							enemy.setCombatX(random.nextInt(4) + 10);
							enemy.setCombatY(random.nextInt(4) + 2);
							break;
						case 2:
							enemy.setCombatX(random.nextInt(4) + 15);
							enemy.setCombatY(random.nextInt(6) + 5);
							break;
						case 3:
							enemy.setCombatX(random.nextInt(4) + 10);
							enemy.setCombatY(random.nextInt(4) + 10);
							break;
						case 4:
							enemy.setCombatX(random.nextInt(3) + 5);
							enemy.setCombatY(random.nextInt(6) + 5);
							break;
						}

				
						int counter = 0;
						
						for (int i = 0; i < Combat.enemies.size(); i++) {
				
							if (Combat.enemies.get(i).getCombatX() == enemy.getCombatX()) {
								if (Combat.enemies.get(i).getCombatY() == enemy.getCombatY()) {
									counter++;
								}
							}
						}
						if (counter < 2) { finished2 = true; }
						}
					
					
				}
				dungeonDeployEnemies = false;
			}
			
			
			
		}
		
		
		
		
		else {		
			
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
						
				switch(deploySituation) {
				
				
				case 1:
					Combat.enemies.get(0).setCombatX(5);
					Combat.enemies.get(0).setCombatY(8);
					Combat.enemies.get(1).setCombatX(5);
					Combat.enemies.get(1).setCombatY(9);
					Combat.enemies.get(2).setCombatX(5);
					Combat.enemies.get(2).setCombatY(10);
					break;
				
				case 2:
					Combat.enemies.get(0).setCombatX(6);
					Combat.enemies.get(0).setCombatY(8);
					Combat.enemies.get(1).setCombatX(6);
					Combat.enemies.get(1).setCombatY(9);
					Combat.enemies.get(2).setCombatX(6);
					Combat.enemies.get(2).setCombatY(10);
					break;
				
				}
			
		}
			
		
	}

}
