package com.redhaan.adventurersGalore.combat;

import java.util.Random;

import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

import gameEngine.ecclesiastes.gfx.Image;

public abstract class CombatMapRoller {
	
	public static CombatMap rollCombatMap(WorldMapTiles terrainType) {
		
		Image image = null;
		int deploySituation = 1;
		Random random = new Random();
		int roll = random.nextInt(100) + 1;
		
		switch (terrainType) {
		
		case DESERT:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;
		case FOREST:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;
		case GRASS:
			image = new Image("/combatMaps/combatMapGrass1.png");
			if (roll > 50) { deploySituation = 1; }
			else { deploySituation = 2; }
			break;
		case ICE:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;
		case MOUNTAIN:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;
		case OCEAN:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;
		case SHALLOW:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;
		case SWAMP:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;

		
		}
		
		
		
		return new CombatMap(image, deploySituation);
		
	}

}
