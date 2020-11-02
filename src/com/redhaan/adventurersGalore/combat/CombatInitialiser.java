package com.redhaan.adventurersGalore.combat;

import com.redhaan.adventurersGalore.worldMap.WorldMap;

public abstract class CombatInitialiser {
	
	public static boolean deployment = false;
	
	public static void CombatInitialise() {
		if(!deployment) {
			Deployer.deploy();
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
