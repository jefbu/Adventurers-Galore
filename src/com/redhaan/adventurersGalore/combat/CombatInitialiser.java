package com.redhaan.adventurersGalore.combat;

public abstract class CombatInitialiser {
	
	public static boolean deployment = false;
	
	public static void CombatInitialise() {
		if(!deployment) {
			Deployer.deploy();
			deployment = true;
		}
		
		
		Combat.combatPhase = CombatPhase.Combat;
		
	}
	

}
