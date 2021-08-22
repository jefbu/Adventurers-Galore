package com.redhaan.adventurersGalore.combat;

import java.util.Random;

import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

import gameEngine.ecclesiastes.gfx.Image;

public abstract class CombatMapRoller {
	
	public static CombatMap rollCombatMap(WorldMapTiles terrainType) {
		
		Image image = null;
		int deploySituation = 1;
		Random random = new Random();
		int deployRoll = random.nextInt(100) + 1;
		int mapRoll = random.nextInt(100) + 1;
		
		switch (terrainType) {
		
		case DESERT:
			image = new Image("/combatMaps/combatMapGrass1.png");
			break;
			
		case FOREST:
			if (mapRoll > 90) { image = new Image("/combatMaps/combatMapForest1.png"); }
			else { image = new Image("/combatMaps/combatMapForest2.png"); }
			break;
			
		case GRASS:
			if (mapRoll > 90) { image = new Image("/combatMaps/combatMapGrass1.png"); }
			else if (mapRoll > 80) { image = new Image("/combatMaps/combatMapGrass2.png"); }
			else { image = new Image("/combatMaps/combatMapGrass3.png"); }

			if (deployRoll > 50) { deploySituation = 1; }
			else { deploySituation = 2; }
			
			break;
		
		case ICE:
			image = new Image("/combatMaps/combatMapIce1.png");
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
			if (mapRoll > 90) { image = new Image("/combatMaps/combatMapForest1.png"); }
			else { image = new Image("/combatMaps/combatMapForest2.png"); }
			break;

		
		}
		
		
		
		return new CombatMap(image, deploySituation);
		
	}

}
