package com.redhaan.adventurersGalore.combat.combatAI;

public abstract class StrategyDecision {
	
	
	public static CombatStrategies decideCombatStrategy() {
		
		return CombatStrategies.Defend;
		
	}

}
