package com.redhaan.adventurersGalore.dungeon;

import java.util.Random;

import com.redhaan.adventurersGalore.combat.CombatMap;

import gameEngine.ecclesiastes.gfx.Image;

public abstract class DungeonMapChooser {
	
	
	private static Random random = new Random();
	private static CombatMap dungeonMap1 = new CombatMap(new Image("/combatMaps/dungeonMap1.png"), 1);
	private static CombatMap dungeonMap2 = new CombatMap(new Image("/combatMaps/dungeonMap2.png"), 1);

	
	public static CombatMap chooseDungeonMap() {
		
		int roll = random.nextInt(2);
		
		switch(roll) {
		
		case 0: return dungeonMap1;
		case 1: return dungeonMap2;
		
		default: return null;
		
		}
		
		
	}
	

}
