package com.redhaan.adventurersGalore.combat;

import com.redhaan.adventurersGalore.entity.party.Party;
import com.redhaan.adventurersGalore.worldMap.WorldMap;
import com.redhaan.adventurersGalore.worldMap.WorldMapTileInfo;
import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

public abstract class CombatInitialiser {
	
	public static boolean deployment = false;
	
	public static void CombatInitialise() {
		
		int tile = Party.getxTile() + Party.getyTile() * 160;
		WorldMapTiles terrain = WorldMapTileInfo.tiles[tile];
		System.out.println(terrain.name());
		if(!Combat.dungeon) { Combat.combatMap = CombatMapRoller.rollCombatMap(terrain); }
		
		
		if(!deployment) {
			Deployer.deploy(Combat.combatMap.deploySituation);
			deployment = true;
		}
		
		if(WorldMap.soundStarted) {
			WorldMap.soundStarted = false;
			WorldMap.soundClip.stop();
		}
		
		Combat.soundClip.loop();
		Combat.soundStarted = true;
		
		
		Combat.combatPhase = CombatPhase.Combat;
		
	}
	

}
