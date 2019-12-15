package com.redhaan.adventurersGalore.combat.combatAI;

public abstract class ActionDecision {

	public static CombatActions decideActionDecision(CombatStrategies combatStrategy) {
		
		return CombatActions.AttackNearestAdventurer;
		
	}
	
}
