package com.redhaan.adventurersGalore.combat.combatAI;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.combat.Attack;
import com.redhaan.adventurersGalore.entity.Monster;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;

public abstract class AttackDecision {
	
	public static void decideAttackDecision(Monster monster, int x, int y) {
		
		boolean targetChosen = false;
		
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {
			
			if (!targetChosen) {
			if (adventurer.inParty) {
				if (adventurer.getCombatX() == x + 1 && adventurer.getCombatY() == y) { targetChosen = true; attackEnemy(monster, adventurer); }
				else if (adventurer.getCombatX() == x - 1 && adventurer.getCombatY() == y) { targetChosen = true; attackEnemy(monster, adventurer); }
				else if (adventurer.getCombatX() == x && adventurer.getCombatY() == y + 1) { targetChosen = true; attackEnemy(monster, adventurer); }
				else if (adventurer.getCombatX() == x && adventurer.getCombatY() == y - 1) { targetChosen = true; attackEnemy(monster, adventurer); }
			}
			}
			
		}
		
		
	}
	
	
	private static void attackEnemy(Monster monster, Adventurer adventurer) {
		
		Attack.attack(monster, adventurer);
		
	}

	
	
	

}
