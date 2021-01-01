package com.redhaan.adventurersGalore.combat;

import com.redhaan.adventurersGalore.worldMap.WorldMap;
import com.redhaan.adventurersGalore.worldMap.WorldMapTiles;

public abstract class CombatInitialiser {
	
	public static boolean deployment = false;
	
	public static void CombatInitialise() {
		
		Combat.combatMap = CombatMapRoller.rollCombatMap(WorldMapTiles.GRASS);
		
		
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
