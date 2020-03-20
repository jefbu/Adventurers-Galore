package com.redhaan.adventurersGalore.combat;

import java.util.Random;

import com.redhaan.adventurersGalore.GameManager;
import com.redhaan.adventurersGalore.GameState;
import com.redhaan.adventurersGalore.entity.adventurer.Adventurer;
import com.redhaan.adventurersGalore.entity.adventurer.LevelUpRoller;

public abstract class CombatConclusion {

	static Random random = new Random();
	
	public static void combatConclude() {
		
		Combat.enemies.clear();
		
		for (Adventurer adventurer: GameManager.adventurers.allAdventurers) {			
			if(adventurer.inParty) {
				adventurer.battlesPassed++;
				adventurer.attackAnimation = false;
				adventurer.turnPassed = false;
				adventurer.setDead(false);
				adventurer.leftClickSituation = PlayerTurnLeftClickSituations.NothingToDo;
				adventurer.moving = false;
				rollForLevelUp(adventurer);
			}			
		}
		
		CombatInitialiser.deployment = false;
		
		
		
		GameManager.gameState = GameState.WorldMap;
		
	}
	
	
	private static void rollForLevelUp(Adventurer adventurer) {
		
		int roll = random.nextInt(100) + 1;
		if (roll + adventurer.battlesPassed > adventurer.getLevel() * 5 + 5) {
			LevelUpRoller.levelUp(adventurer);
			adventurer.setLevel(adventurer.getLevel() + 1);
		}
		
	}
	

}
